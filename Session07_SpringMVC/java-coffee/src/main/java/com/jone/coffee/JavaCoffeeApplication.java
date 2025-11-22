package com.jone.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication// có @EnableAutoConfiguration: tự new, tự cấu hình JPA/Hibernate, tomcat, MVC...
public class JavaCoffeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaCoffeeApplication.class, args);
	}
   
	//@Bean ở đây để chủ động new riêng những dependency, new xong gửi cho IoC Container quản lí 
}
