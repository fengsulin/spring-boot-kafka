package com.lne.kafka.operator.service.impl;

import com.lne.kafka.operator.entity.OperationSource;
import com.lne.kafka.operator.mapper.OperationSourceMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lne.kafka.operator.service.IOperationSourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 资源池 服务实现类
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
@Service
public class OperationSourceServiceImpl extends ServiceImpl<OperationSourceMapper, OperationSource> implements IOperationSourceService {

    @Resource
    private OperationSourceMapper operationSourceMapper;
    @Override
    public Integer insertOrUpdate(OperationSource operationSource) {
        return operationSourceMapper.insertOrUpdate(operationSource);
    }
}
