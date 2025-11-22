package com.jone.coffee.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jone.coffee.entity.Coffee;

@RestController
@RequestMapping("/api/v1") // phục vụ các url mà muốn lấy data thô, trả về JSON hoặc nhận JSON từ trang web
							// gửi lên
public class CoffeeAPI {

	@GetMapping("/cup")
	public Coffee getCup() {
		return new Coffee("re", "ppppp", 34234);
		// lấy từ DB lên qua Service/Repository/JPA-Hibernate/JDBC/TABLE
		// gọi J convert từ object thành JSON bên trình duyệt
		// data thôi- web api: gọi hàm qua URL trả về JSON
		// Swagger UI: help, document chứa URL để dùng thử API
	}
	
	//gửi data lên server, JSON gửi lên
	@PostMapping("/cup")
	public Coffee addCoffee(@RequestBody Coffee cup) {
		//SỬA OBJECT ĐÃ NHẬN, XONG TRẢ VỀ ĐỂ BIẾT MÌNH ĐÃ NHẬN TỪ CLIENRT VÀ CHỈNH INFO
		String oldName = cup.getName();
		String newName = oldName + "Cô gái nhà bên Hoài Anh";
		cup.setName(newName);
		return cup;
	}
}
