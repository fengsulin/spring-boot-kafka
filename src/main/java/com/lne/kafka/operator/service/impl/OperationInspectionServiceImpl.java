package com.lne.kafka.operator.service.impl;

import com.lne.kafka.operator.entity.OperationInspection;
import com.lne.kafka.operator.mapper.OperationInspectionMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lne.kafka.operator.service.IOperationInspectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 巡检表 服务实现类
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
@Service
public class OperationInspectionServiceImpl extends ServiceImpl<OperationInspectionMapper, OperationInspection> implements IOperationInspectionService {

    @Resource
    private OperationInspectionMapper operationInspectionMapper;
    @Override
    public Integer insertOrUpdate(OperationInspection operationInspection) {
        return operationInspectionMapper.insertOrUpdate(operationInspection);
    }
}
