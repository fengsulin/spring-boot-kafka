package com.lne.kafka.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;

@Slf4j
@Configuration
public class ConsumerExceptionHandler {

    @Bean
    public ConsumerAwareListenerErrorHandler consumerAwareErrorHandler(){
        return (massage,exception,consumer) ->{
            log.warn("消息异常："+massage.getPayload());
            return null;
        };
    }
}
