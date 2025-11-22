package com.jone;

import org.springframework.stereotype.Component;

//@Component
public class ExcelGenerator {

	public void generateFile(String fileName) {
		System.out.println("Spring Boot: the " + fileName + ".xlsx has been generated");
	}
}
