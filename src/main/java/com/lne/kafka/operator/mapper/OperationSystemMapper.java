package com.lne.kafka.operator.mapper;

import com.lne.kafka.operator.entity.OperationSystem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 系统表 Mapper 接口
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
public interface OperationSystemMapper extends BaseMapper<OperationSystem> {
    public Integer insertOrUpdate(OperationSystem operationSystem);

}
