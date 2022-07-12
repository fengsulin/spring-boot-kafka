//package com.lne.kafka.config;
//
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class KafkaInitialConfiguration {
//    // 创建一个名为topic52的Topic并设置分区数为3，分区副本为2
//    @Bean
//    public NewTopic initialTopic(){
//        return new NewTopic("topic52-1",3,(short)2);
//    }
//    /**
//     * 如果要修改分区数，只需修改配置值重启项目即可
//     * 修改分区不会导致数据丢失，但分区数只能增大，不能减少
//     */
//}
