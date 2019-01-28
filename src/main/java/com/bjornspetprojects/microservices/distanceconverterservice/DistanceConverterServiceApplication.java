package com.bjornspetprojects.microservices.distanceconverterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.bjornspetprojects.microservices.distanceconverterservice")
@EnableDiscoveryClient
public class DistanceConverterServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(DistanceConverterServiceApplication.class, args);
	}

}

