package com.jone.spring.spring_to_go.ioc.v2bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration // báo chùm cuối ApplicationContext vào đây tìm info để new các bean, quản lí chung
public class AppConfig {

	//@Bean("phanlangtu") //object được return từ hàm này, đi vào container ngay
	//chủ động new là mình, chủ động đặt tên object, nhưng đưa obj cho Container
	//TÊN HÀM PHÁ CHUẨN VERB + OBJECT TRUYỀN THỐNG MÀ MANG Ý NGHĨA TÊN BIẾN OBJ, ĐỂ ĐC DÙNG NGẦM TRONG CONTAINER
//	public PdfGenerator pdfGenerator() {
//		return new PdfGenerator();//nếu class/bean gốc có constructor có tham số, dùng bean tự new, tự truyền tham số vào constructor
//		//spring sẽ không truyền tham số đc vì nó không biết truyền tham số nào, kiểu gì
//	}
	
	//PdfGenerator gen = getPdfGenerator(); = pdfGenerator() = new PdfGenerator()
	
	@Bean
	public DocumentGenerator pdfGenerator() {
		return new PdfGenerator();
	}

	@Bean	
	public DocumentGenerator excelGenerator() {
		return new ExcelGenerator();
	}
}
