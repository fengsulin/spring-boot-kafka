package com.lne.kafka.kafkaService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.lne.kafka.constant.MetricValue;
import com.lne.kafka.operator.entity.*;
import com.lne.kafka.operator.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Slf4j
public class ConsumerBatch {

    @Resource
    private IOperationServiceService iOperationServiceService;
    @Resource
    private IOperationHostsService iOperationHostsService;
    @Resource
    private IOperationSystemService iOperationSystemService;
    @Resource
    private IOperationCategoryService iOperationCategoryService;
    @Resource
    private IOperationInspectionService iOperationInspectionService;
    @Resource
    private IOperationSourceService iOperationSourceService;


    @Transactional(propagation = Propagation.REQUIRED)
    public void batchSave(List<ConsumerRecord<?, ?>> records){
        log.info("###############开始进行数据入库##################");
        if (records == null || records.size() < 1){
            log.warn("records为null或为空！");
            return;
        }
        for(ConsumerRecord<?,?> consumerRecord:records){
            String consumer = consumerRecord.value().toString();
            log.info(consumer);
            JSONObject jsonObject = JSON.parseObject(consumer);
            String categoryName = jsonObject.getString(MetricValue.NAME);
            String metricValue =  jsonObject.getString(MetricValue.VALUE);
            JSONObject labels = (JSONObject) jsonObject.get(MetricValue.LABELS);
            String instance = labels.getString(MetricValue.INSTANCE);
            String valueTime = jsonObject.getString(MetricValue.TIME);
            LocalDateTime localDateTime = null;
            if(valueTime != null && !valueTime.isEmpty()){
                localDateTime = LocalDateTime.parse(valueTime, DateTimeFormatter.ISO_DATE_TIME);
            }

            boolean resource = labels.containsKey(MetricValue.RESOURCE);
            boolean serverType = labels.containsKey(MetricValue.SERVER_TYPE);
            boolean project = labels.containsKey(MetricValue.PROJECT);
            boolean job = labels.containsKey(MetricValue.JOB);
            boolean service = labels.containsKey(MetricValue.SERVICE_NAME);

            // 正则表达式匹配ip和端口
            String ip = "";
            String port = "";
            if(!instance.isEmpty()&& instance != null){
                Pattern pattern = Pattern.compile("(\\d+\\.\\d+\\.\\d+\\.\\d+)\\:(\\d+)");
                Matcher matcher = pattern.matcher(instance);
                while (matcher.find()){
                    ip = matcher.group(1);
                    port = matcher.group(2);
                }
            }

            // 指标类别
            OperationCategory operationCategory = new OperationCategory();
            operationCategory.setCategoryName(categoryName);
            long categoryId = IdWorker.getId();
            operationCategory.setId(categoryId);
            operationCategory.setIsDelete(0);
            iOperationCategoryService.insertOrUpdate(operationCategory);

            // 资源池
            long resourceId = 0;
            String resourceName = null;
            if(resource){
                OperationSource operationSource = new OperationSource();
                resourceName = labels.getString(MetricValue.RESOURCE);
                operationSource.setSourceName(resourceName);
                resourceId = IdWorker.getId();
                operationSource.setId(resourceId);
                operationSource.setIsDelete(0);
                iOperationSourceService.insertOrUpdate(operationSource);
            }

            // 主机
            OperationHosts operationHosts = new OperationHosts();
            long hostId = IdWorker.getId();
            operationHosts.setId(hostId);
            operationHosts.setHostIp(ip);
            operationHosts.setIsNanotubes(0);
            String serverTypes = labels.getString(MetricValue.SERVER_TYPE);
            if(serverType){
                operationHosts.setHostType(serverTypes);
            }
                QueryWrapper<OperationHosts> operationHostsQueryWrapper = new QueryWrapper<>();
                operationHostsQueryWrapper.eq("host_ip",ip);
                List<OperationHosts> list = iOperationHostsService.list(operationHostsQueryWrapper);
                if(list != null && list.size()>0){
                    Long resourceId1 = list.get(0).getResourceId();
                    if(resourceId1 != null){
                        operationHosts.setResourceId(resourceId1);
                    }
                }else if(resource){
                    QueryWrapper<OperationSource> operationSourceQueryWrapper = new QueryWrapper<>();
                    operationSourceQueryWrapper.eq("source_name",resourceName);
                    List<OperationSource> sourceList = iOperationSourceService.list(operationSourceQueryWrapper);
                    if(sourceList == null || sourceList.size()<1){
                        operationHosts.setResourceId(resourceId);
                    }
                    operationHosts.setResourceId(sourceList.get(0).getId());
                }
            iOperationHostsService.insertOrUpdate(operationHosts);
            // 系统
            long systemId = 0;
            String systemName = null;
            if(project){
                OperationSystem operationSystem = new OperationSystem();
                systemId = IdWorker.getId();
                operationSystem.setId(systemId);
                systemName = labels.getString(MetricValue.PROJECT);
                operationSystem.setSystemName(systemName);
                operationSystem.setIsDelete(0);
                iOperationSystemService.insertOrUpdate(operationSystem);
            }

            // 服务
            long serviceId = 0;
            String serviceName = null;
            if(service){
                OperationService operationService = new OperationService();
                serviceId = IdWorker.getId();
                operationService.setId(serviceId);
                operationService.setServiceUrl(ip);
                operationService.setServicePort(port);
                operationService.setIsDelete(0);
                operationService.setIsNanotubes(0);
                serviceName = labels.getString(MetricValue.SERVICE_NAME);
                operationService.setServiceName(labels.getString(MetricValue.SERVICE_NAME));
                QueryWrapper<OperationService> operationServiceQueryWrapper = new QueryWrapper<>();
                operationServiceQueryWrapper.eq("service_name",serviceName);
                List<OperationService> list1 = iOperationServiceService.list(operationServiceQueryWrapper);
                if(list1 != null && list1.size()>0){
                    Long systemId1 = list1.get(0).getSystemId();
                    if(systemId1 != null && !systemId1.equals("")){
                        operationService.setSystemId(systemId1);

                    }
                }
                else if(project){
                    QueryWrapper<OperationSystem> operationSystemQueryWrapper = new QueryWrapper<>();
                    operationSystemQueryWrapper.eq("system_name",systemName);
                    List<OperationSystem> systemList = iOperationSystemService.list(operationSystemQueryWrapper);
                    if(systemList != null && systemList.size()>0){
                        operationService.setSystemId(systemList.get(0).getId());
                    }else {
                        operationService.setSystemId(systemId);
                    }
                }
                iOperationServiceService.insertOrUpdate(operationService);
            }

            // 巡检
            if(job){
                OperationInspection operationInspection = new OperationInspection();
                long inspectionId = IdWorker.getId();
                operationInspection.setId(inspectionId);
                String inspectionName = labels.getString(MetricValue.JOB);
                operationInspection.setInspectionName(inspectionName);
                operationInspection.setInspectionValue(metricValue);
                operationInspection.setCategoryId(categoryId);

                QueryWrapper<OperationInspection> operationInspectionQueryWrapper = new QueryWrapper<>();
                operationInspectionQueryWrapper.eq("inspection_name",inspectionName);
                List<OperationInspection> list2 = iOperationInspectionService.list(operationInspectionQueryWrapper);
                if(list2 != null && list2.size()>0){
                    OperationInspection operationInspection1 = list2.get(0);
                    if(operationInspection1.getCategoryId() != null){
                        operationInspection.setCategoryId(operationInspection1.getCategoryId());
                    }
                    // 判断该巡检是否已有web服务（~~~~~~~~~todo~~~~~~~~~~~）
                    if(operationInspection1.getServiceId() != null){
                        operationInspection.setServiceId(operationInspection1.getServiceId());
                    }
                }else if(service){
                    QueryWrapper<OperationService> operationServiceQueryWrapper = new QueryWrapper<>();
                    operationServiceQueryWrapper.eq("service_name",serviceName);
                    List<OperationService> list1 = iOperationServiceService.list(operationServiceQueryWrapper);
                    if(list1 != null && list1.size()>0){
                        operationInspection.setServiceId(list1.get(0).getId());
                    }else {
                        operationInspection.setServiceId(serviceId);
                    }
                    }

                operationInspection.setInspectionTime(localDateTime);
                iOperationInspectionService.insertOrUpdate(operationInspection);
            }

        }
        log.info("##############批次数据已入库#########################");
    }
}
