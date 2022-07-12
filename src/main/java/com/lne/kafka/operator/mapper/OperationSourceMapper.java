package com.lne.kafka.operator.mapper;

import com.lne.kafka.operator.entity.OperationSource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 资源池 Mapper 接口
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
public interface OperationSourceMapper extends BaseMapper<OperationSource> {
    public Integer insertOrUpdate(OperationSource operationSource);

}
