package com.lne.kafka.operator.service;

import com.lne.kafka.operator.entity.OperationService;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * web服务表 服务类
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
public interface IOperationServiceService extends IService<OperationService> {
    public Integer insertOrUpdate(OperationService operationService);
}
