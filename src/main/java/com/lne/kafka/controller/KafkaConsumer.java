package com.lne.kafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class KafkaConsumer {

//    // 消费监听
//    @KafkaListener(topics = {"topic52-1",},errorHandler = "consumerAwareListenerErrorHandler")
//    public void onMessage1(ConsumerRecord<?,?> record){
//        // 消费的那个topic、partition的消息，打印出消息内容
//        System.out.println(record.topic()+"-"+record.partition()+"-"+record.value());
//    }
//
    /**
     * 指定topic、partition、offset消费
     */
    @KafkaListener(id = "consumer-1",groupId = "monitorSystem",
    topicPartitions = {
            @TopicPartition(topic = "topic52-1",partitions = {"0"},partitionOffsets = @PartitionOffset(partition = "1",initialOffset = "5"))
    },containerFactory = "filterContainerFactory")
    public void onMessage2(ConsumerRecord<?,?> record){
        log.info(record.topic()+"-"+record.partition()+"-"+record.value());
    }

//    // 批量消费
//    @KafkaListener(topics = "topic52-1",errorHandler = "consumerAwareListenerErrorHandler")
//    public void onMessage4(List<ConsumerRecord<?,?>> records) throws Exception {
//        System.out.println("批量消费一次。。。。。");
//        throw new Exception("模拟消费异常");
//    }
}
