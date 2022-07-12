package com.lne.kafka.operator.mapper;

import com.lne.kafka.operator.entity.OperationCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 监控属性类别表 Mapper 接口
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
public interface OperationCategoryMapper extends BaseMapper<OperationCategory> {
    public Integer insertOrUpdate(OperationCategory operationCategory);

}
