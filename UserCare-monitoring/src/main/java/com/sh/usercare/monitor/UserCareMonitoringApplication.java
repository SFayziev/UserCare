package com.sh.usercare.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class UserCareMonitoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCareMonitoringApplication.class, args);
	}
}
