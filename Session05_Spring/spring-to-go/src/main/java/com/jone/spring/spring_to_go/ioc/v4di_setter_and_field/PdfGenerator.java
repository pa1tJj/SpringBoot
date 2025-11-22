package com.jone.spring.spring_to_go.ioc.v4di_setter_and_field;

import org.springframework.stereotype.Component;

@Component
public class PdfGenerator {

	public void generateFile(String fileName) {
		//TODO: logic xử lí gen ra file pdf
		
		System.out.println("V4 DI IoC Setter-> The pdf file " + fileName + ".pdf has been generated successfully!");
	}

}
