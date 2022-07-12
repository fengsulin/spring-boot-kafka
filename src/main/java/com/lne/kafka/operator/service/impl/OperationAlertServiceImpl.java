package com.lne.kafka.operator.service.impl;

import com.lne.kafka.operator.entity.OperationAlert;
import com.lne.kafka.operator.mapper.OperationAlertMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lne.kafka.operator.service.IOperationAlertService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 告警表 服务实现类
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
@Service
public class OperationAlertServiceImpl extends ServiceImpl<OperationAlertMapper, OperationAlert> implements IOperationAlertService {

}
