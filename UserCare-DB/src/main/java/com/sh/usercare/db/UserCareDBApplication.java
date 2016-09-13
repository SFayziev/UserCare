package com.sh.usercare.db;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class UserCareDBApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCareDBApplication.class, args);
	}


}
