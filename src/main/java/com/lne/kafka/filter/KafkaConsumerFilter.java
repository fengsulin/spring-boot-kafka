package com.lne.kafka.filter;

import com.alibaba.fastjson.JSONObject;
import com.lne.kafka.constant.MetricValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;

import javax.annotation.Resource;

@Configuration
@Slf4j
public class KafkaConsumerFilter {
    @Resource
    ConsumerFactory consumerFactory;

    // 消息过滤器
    @Bean
    public ConcurrentKafkaListenerContainerFactory filterContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        // 被过滤的消息将被遗弃
        factory.setAckDiscarded(true);
        // 并发数
        factory.setConcurrency(3);
        factory.setBatchListener(true);
        ContainerProperties containerProperties = factory.getContainerProperties();
        containerProperties.setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        // 消息过滤策略
        factory.setRecordFilterStrategy(consumerRecord -> {
            String consumer = consumerRecord.value().toString();
            JSONObject jsonObject = JSONObject.parseObject(consumer);
            String objectString = jsonObject.getString(MetricValue.NAME);
            if(objectString.equals("node_systemd_version")){
                log.info("=====================保留=========================");
                return false;
            }else {
                // 返回true消息则被过滤
                return true;
            }
        });
        return factory;
    }
}
