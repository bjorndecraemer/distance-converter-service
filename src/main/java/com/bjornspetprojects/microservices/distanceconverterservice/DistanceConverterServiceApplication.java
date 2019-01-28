package com.bjornspetprojects.microservices.distanceconverterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.bjornspetprojects.microservices.distanceconverterservice")
public class DistanceConverterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistanceConverterServiceApplication.class, args);
	}

}

