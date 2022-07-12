package com.lne.kafka.operator.service;

import com.lne.kafka.operator.entity.OperationHosts;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lne.kafka.operator.entity.OperationService;

/**
 * <p>
 * 主机表 服务类
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
public interface IOperationHostsService extends IService<OperationHosts> {
    public Integer insertOrUpdate(OperationHosts operationHosts);
}
