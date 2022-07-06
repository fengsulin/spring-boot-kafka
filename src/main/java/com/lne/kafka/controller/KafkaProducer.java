package com.lne.kafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/v1/kafka")
public class KafkaProducer {
    @Resource
    private KafkaTemplate<String,Object> kafkaTemplate;

    // 发送消息
    @GetMapping("/normal/{message}")
    public void sendMessage1(@PathVariable("message") String normalMessage){
        kafkaTemplate.send("topic52-1",normalMessage);
    }

    // 回调方法addCCallback，消息发送后，回调方法对消息发送成功与否进行处理
    @GetMapping("/callbackOne/{message}")
    public void sendMessage2(@PathVariable("message") String message){
        kafkaTemplate.send("topic52-1",message).addCallback(success ->{
            String topic = success.getRecordMetadata().topic();
            int partition = success.getRecordMetadata().partition();
            long offset = success.getRecordMetadata().offset();
            log.info("发送消息成功:" + topic + "-" + partition + "-" + offset);
        },failure ->{
            log.warn("消息发送失败："+failure.getMessage());
        });
    }

    // 事务提交
    @GetMapping("/transaction")
    public void sendMessage3(@RequestParam("message") String message){
        // 声明事务，后面报错，前面的消息不会发送
        kafkaTemplate.executeInTransaction(operations ->{
            operations.send("topic52-1",message);
            log.info("发送成功！");
            return null;
//            throw new RuntimeException("fail");
        });
        // 不声明事务，后面报错前面的消息会发送成功
    }
}
