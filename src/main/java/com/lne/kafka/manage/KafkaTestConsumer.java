package com.lne.kafka.manage;

import com.lne.kafka.kafkaService.ConsumerBatch;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class KafkaTestConsumer {
    @Autowired
    private ConsumerBatch consumerBatch;

    int recordSize = 0;
    @KafkaListener(topics = "devops-prometheus"
            ,groupId = "kafka-zw-bj-3-8"
            ,containerFactory = "filterContainerFactory"
//            ,errorHandler = "consumerAwareErrorHandler"
    )
    public void onMessageBatch(List<ConsumerRecord<?,?>> records, Acknowledgment ack){
        recordSize+=records.size();
        log.info("####################"+"kafka当前消费数据量为："+recordSize+"#############################");
        consumerBatch.batchSave(records);

        ack.acknowledge();

    }

//    @KafkaListener(topics = {"devops-prometheus"},groupId = "zhTestGroup7-6")
//    public void onMessageSingle(ConsumerRecord<?,?> record,Acknowledgment ack){
//        if(record != null){
//            String recordMsg = record.value().toString();
//            System.out.println(recordMsg);
//        }
//        ack.acknowledge();
//    }
}
