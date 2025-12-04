package com.jone.springredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringredisObjectCacheableApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringredisObjectCacheableApplication.class, args);
	}

}
