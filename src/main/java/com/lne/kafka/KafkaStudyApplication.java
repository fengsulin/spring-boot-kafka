package com.lne.kafka;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lne.kafka.operator.mapper")
public class KafkaStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaStudyApplication.class, args);
	}

}
