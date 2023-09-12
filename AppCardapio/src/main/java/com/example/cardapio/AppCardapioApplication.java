package com.example.cardapio;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.cardapio.services", "com.example.cardapio.controller"})
public class AppCardapioApplication {

	@Bean
	RestTemplate template(){
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AppCardapioApplication.class, args);
	
		
	}
}