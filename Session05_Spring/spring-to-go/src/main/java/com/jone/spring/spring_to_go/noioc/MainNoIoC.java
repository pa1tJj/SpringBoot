package com.jone.spring.spring_to_go.noioc;

public class MainNoIoC {

	// NƠI TẠO RA OBJECT, TẠO RA DEPENDENCY, TIÊM CHÍCH VÀO TRONG OBJECT CHÍNH
	// IoC container : nơi kiểm soát những phụ thuộc và tiêm/chích chúng vào 
	//Ioc tự tạo - chưa dùng hàng xịn từ Spring
	
	public static void main(String[] args) {
		PdfGenerator pdfGenerator = new PdfGenerator();
		ConstractService constractService = new ConstractService(pdfGenerator);
		constractService.processConstract();
	}

}
