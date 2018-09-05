package com.springboot.lanceapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@PropertySource("classpath:knightRepository.properties")
//@ImportResource("classpath:config/spring-config.xml")
@EnableScheduling
public class LanceappApplication {

	public static void main(String[] args) {
		SpringApplication.run(LanceappApplication.class, args);
	}
}
