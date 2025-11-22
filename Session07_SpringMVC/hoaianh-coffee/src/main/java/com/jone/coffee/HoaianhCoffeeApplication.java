package com.jone.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//class này là class trung tâm, nơi chứa những khai báo về các loại bean có trong app này: bean là những object dependency được  IoC Container tự new, hay mình tự new
//và gửi cho Container giữ giúp
//Dependency object là những class có @Component, @Service, @Repository, @Controller, @RestController
//@SpringBootApplication: gộp sẵn - @Configuration, @ComponentScan, @EnableAutoConfiguration: khởi động Tomcat, JPA/Hibernate, MVC - điều khiển request/response
public class HoaianhCoffeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoaianhCoffeeApplication.class, args);
	}

}
