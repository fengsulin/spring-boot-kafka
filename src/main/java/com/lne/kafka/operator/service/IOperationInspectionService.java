package com.lne.kafka.operator.service;

import com.lne.kafka.operator.entity.OperationInspection;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 巡检表 服务类
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
public interface IOperationInspectionService extends IService<OperationInspection> {
    public Integer insertOrUpdate(OperationInspection operationInspection);
}
