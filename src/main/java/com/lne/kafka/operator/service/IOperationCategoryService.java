package com.lne.kafka.operator.service;

import com.lne.kafka.operator.entity.OperationCategory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 监控属性类别表 服务类
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
public interface IOperationCategoryService extends IService<OperationCategory> {
    public Integer insertOrUpdate(OperationCategory operationCategory);
}
