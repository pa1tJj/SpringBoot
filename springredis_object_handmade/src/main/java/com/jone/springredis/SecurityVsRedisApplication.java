package com.jone.springredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SecurityVsRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityVsRedisApplication.class, args);
	}

}
