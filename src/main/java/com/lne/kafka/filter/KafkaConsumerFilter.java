package com.lne.kafka.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
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
        // 消息过滤策略
        factory.setRecordFilterStrategy(consumerRecord -> {
            if(consumerRecord.value().toString().contains("hhhh")){
                return false;
            }else {
                // 返回true消息则被过滤
                return true;
            }
        });
        return factory;
    }
}
