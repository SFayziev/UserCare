package com.sh.usercare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients
public class UserCareApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserCareApiApplication.class, args);
	}
}
