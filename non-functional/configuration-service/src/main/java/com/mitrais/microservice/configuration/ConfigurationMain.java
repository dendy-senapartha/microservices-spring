package com.mitrais.microservice.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Application entry point.
 *
 * @author Kustian@mitrais.com
 */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class ConfigurationMain {
	public static void main(String[] args) {
		SpringApplication.run(ConfigurationMain.class, args);
	}
}
