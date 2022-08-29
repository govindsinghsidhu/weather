package com.application.test;

import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.client.RestTemplate;

import com.application.service.WeatherService;
import com.application.service.WeatherServiceImpl;

@SpringBootTest
class TestApplicationTests implements ApplicationContextAware {

	private ApplicationContext context;

	@Override
	@Autowired
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;

	}

	@Autowired
	RestTemplate restTemplate;

	@Test
	void contextLoadsTest() {
	}

	@Test
	void checkBeanTest() {
		WeatherService weatherService = context.getBean("WeatherService", WeatherService.class);
		assertEquals(WeatherServiceImpl.class, weatherService.getClass());
	}

}
