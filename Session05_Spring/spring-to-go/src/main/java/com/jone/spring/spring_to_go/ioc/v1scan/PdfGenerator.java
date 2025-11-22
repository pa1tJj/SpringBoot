package com.jone.spring.spring_to_go.ioc.v1scan;

import org.springframework.stereotype.Component;

@Component //nghĩa là: đây là một object, 1 bean sẽ được tự động new bởi thư viện Spring, Spring Context
//@Service, @Repository là con của @Component
public class PdfGenerator {

	//LÀM GIẢ hàm generateFile()
	
	public void generateFile(String fileName) {
		//TODO: logic xử lí gen ra file pdf
		
		System.out.println("V1 -> The pdf file " + fileName + ".pdf has been generated successfully!");
	}
}
