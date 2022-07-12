package com.lne.kafka.operator.mapper;

import com.lne.kafka.operator.entity.OperationService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * web服务表 Mapper 接口
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
public interface OperationServiceMapper extends BaseMapper<OperationService> {
    public Integer insertOrUpdate(OperationService operationService);

}
