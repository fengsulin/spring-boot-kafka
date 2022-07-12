package com.lne.kafka.operator.service.impl;

import com.lne.kafka.operator.entity.OperationSystem;
import com.lne.kafka.operator.mapper.OperationSystemMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lne.kafka.operator.service.IOperationSystemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 系统表 服务实现类
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
@Service
public class OperationSystemServiceImpl extends ServiceImpl<OperationSystemMapper, OperationSystem> implements IOperationSystemService {

    @Resource
    private OperationSystemMapper operationSystemMapper;
    @Override
    public Integer insertOrUpdate(OperationSystem operationSystem) {
        return operationSystemMapper.insertOrUpdate(operationSystem);
    }
}
