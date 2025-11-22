package com.jone.spring.spring_to_go.ioc.v4di_setter_and_field;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV4 {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ContractService contractService = context.getBean(ContractService.class);
		contractService.processContract();
	}

}
