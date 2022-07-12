package com.lne.kafka.operator.service.impl;

import com.lne.kafka.operator.entity.OperationService;
import com.lne.kafka.operator.mapper.OperationServiceMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lne.kafka.operator.service.IOperationServiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * web服务表 服务实现类
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
@Service
public class OperationServiceServiceImpl extends ServiceImpl<OperationServiceMapper, OperationService> implements IOperationServiceService {

    @Resource
    private OperationServiceMapper operationServiceMapper;
    @Override
    public Integer insertOrUpdate(OperationService operationService) {
        return operationServiceMapper.insertOrUpdate(operationService);
    }
}
