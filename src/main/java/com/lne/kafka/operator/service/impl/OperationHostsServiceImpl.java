package com.lne.kafka.operator.service.impl;

import com.lne.kafka.operator.entity.OperationHosts;
import com.lne.kafka.operator.entity.OperationService;
import com.lne.kafka.operator.mapper.OperationHostsMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lne.kafka.operator.mapper.OperationServiceMapper;
import com.lne.kafka.operator.service.IOperationHostsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 主机表 服务实现类
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
@Service
public class OperationHostsServiceImpl extends ServiceImpl<OperationHostsMapper, OperationHosts> implements IOperationHostsService {

    @Resource
    private OperationHostsMapper operationHostsMapper;
    @Override
    public Integer insertOrUpdate(OperationHosts operationHosts) {
        return operationHostsMapper.insertOrUpdate(operationHosts);
    }
}
