package com.jone.coffee.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jone.coffee.entity.Coffee;

@Controller // 1 bean được tự new từ đầu bởi Container, chuyên trả lời các http request đến từ URL của trình duyệt user
//có nhiều url khác nhau, thì ứng với nhiều hàm trong class này
//các hàm trả vể html
public class CoffeeController {

	@GetMapping(value =  "/home")
	public String getCoffee(Model model) {
		model.addAttribute("coffee", "Cà phê Trung Nguyên");
		model.addAttribute("jc", new Coffee("jv", "jfasd", 3000));
		return "index"; //trả về tên trang cho trình duyệt
	}
}
