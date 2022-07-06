package com.lne.kafka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;

@Configuration
public class KafkaConsumerExceptionHandler {

    @Bean
    public ConsumerAwareListenerErrorHandler consumerAwareListenerErrorHandler(){
        return (message,exception,consumer) ->{
            System.out.println("消费异常："+message.getPayload());
            return null;
        };
    }

}
