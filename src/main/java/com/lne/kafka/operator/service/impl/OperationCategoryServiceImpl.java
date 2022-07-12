package com.lne.kafka.operator.service.impl;

import com.lne.kafka.operator.entity.OperationCategory;
import com.lne.kafka.operator.mapper.OperationCategoryMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lne.kafka.operator.service.IOperationCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 监控属性类别表 服务实现类
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
@Service
public class OperationCategoryServiceImpl extends ServiceImpl<OperationCategoryMapper, OperationCategory> implements IOperationCategoryService {

    @Resource
    private OperationCategoryMapper operationCategoryMapper;

    @Override
    public Integer insertOrUpdate(OperationCategory operationCategory) {
        return  operationCategoryMapper.insertOrUpdate(operationCategory);
    }
}
