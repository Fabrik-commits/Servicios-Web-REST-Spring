package com.spring.boot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebRestSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebRestSpringApplication.class, args);
	}
	
	@Bean
	public ModelMapper ModelMaper() {
		return new ModelMapper();
	}

}
