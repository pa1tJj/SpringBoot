package com.jone.spring.spring_to_go.ioc.v3di_constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV3 {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	    //hiện tại có 2 thằng bean: Service và Generator 
		ConstractService constractService = context.getBean(ConstractService.class);
	    constractService.processConstract();
	}

}
