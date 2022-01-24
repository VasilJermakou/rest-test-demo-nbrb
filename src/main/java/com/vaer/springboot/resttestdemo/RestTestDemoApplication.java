package com.vaer.springboot.resttestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestTestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTestDemoApplication.class, args);

	}

	@Bean
	RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

}
