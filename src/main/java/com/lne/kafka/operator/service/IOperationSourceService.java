package com.lne.kafka.operator.service;

import com.lne.kafka.operator.entity.OperationSource;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 资源池 服务类
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
public interface IOperationSourceService extends IService<OperationSource> {
    public Integer insertOrUpdate(OperationSource operationSource);

}
