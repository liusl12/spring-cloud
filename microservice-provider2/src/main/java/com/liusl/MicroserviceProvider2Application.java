package com.liusl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceProvider2Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProvider2Application.class, args);
	}
}
