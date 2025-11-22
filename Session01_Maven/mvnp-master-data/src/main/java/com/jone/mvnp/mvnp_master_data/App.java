package com.jone.mvnp.mvnp_master_data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jone.mvnp.mvnp_master_data.entity.Student;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws JsonProcessingException{
    	Student an = new Student("sv01", "Đỗ Phúc An", 2004, 3.3);
    	Student binh = new Student("sv02", "Trung Văn Bình", 2004, 3.7);
    	
    	System.out.println(an);
    	System.out.println(binh);
    	
    	//TRONG MÔ HÌNH LÀM WEB APP GỒM FE VÀ BE
    	//FRONT-END -----  JSON ----- BACK-END
    	
    	//CHƠI VỚI JSON
    	//TỪ OBJECT THÀNH JSON, BE GỬI FE
    	//CẦN TẠO OBJECT QUẢN LÍ JSON TỪ THƯ VIỆN JACKSON
    	ObjectMapper objectMapper = new ObjectMapper();
    	String anJson = objectMapper.writeValueAsString(an);
    	System.out.println(anJson);
    	
    	//TỪ JSON THÀNH OBJECT, FE GỬI BE
    	String cuongJson = """
    			           {"id":"sv03","name":"Cường Mai","yob":2006,"gpa":2.5}""";//PHẢI BẮT ĐẦU """ VÀ XUỐNG DÒNG THÌ MỚI LƯU ĐƯỢC CHUỖI JSON
    	Student cuong = objectMapper.readValue(cuongJson, Student.class); //ĐƯA CHUỖI CONVERT THÀNH OBJECT THUỘC CLASS NÀO.
    	System.out.println(cuong);
    	
    }
}
