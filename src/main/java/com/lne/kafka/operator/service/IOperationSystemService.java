package com.lne.kafka.operator.service;

import com.lne.kafka.operator.entity.OperationService;
import com.lne.kafka.operator.entity.OperationSystem;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统表 服务类
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
public interface IOperationSystemService extends IService<OperationSystem> {
    public Integer insertOrUpdate(OperationSystem operationSystem);

}
