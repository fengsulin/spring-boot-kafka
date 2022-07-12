package com.lne.kafka.operator.mapper;

import com.lne.kafka.operator.entity.OperationInspection;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 巡检表 Mapper 接口
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
public interface OperationInspectionMapper extends BaseMapper<OperationInspection> {
    public Integer insertOrUpdate(OperationInspection operationInspection);
}
