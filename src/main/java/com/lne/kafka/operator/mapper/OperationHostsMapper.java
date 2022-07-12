package com.lne.kafka.operator.mapper;

import com.lne.kafka.operator.entity.OperationHosts;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 主机表 Mapper 接口
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
public interface OperationHostsMapper extends BaseMapper<OperationHosts> {
    public Integer insertOrUpdate(OperationHosts operationHosts);

}
