package com.mitrais.microservice.order;

import com.mitrais.microservice.order.event.CreateOrderEventHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderMain {
	public static void main(String[] args) {
		SpringApplication.run(OrderMain.class, args);
	}

	@Bean
	public CreateOrderEventHandler createOrderEventHandler(){
		return new CreateOrderEventHandler();
	}
}
