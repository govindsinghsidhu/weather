package com.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(Application.class);
		logger.info("Weather application is starting up");
		SpringApplication.run(Application.class, args);
		
	}
	
}