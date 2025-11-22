package com.jone.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jone.coffee.model.dto.AccountDTO;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {
	@GetMapping("/login")
	public String getLogin(Model model) {
		model.addAttribute("acc", new AccountDTO());
		return "login";
	}
	
	@GetMapping("/logout")
	public String getLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}

//SESSION: THÔNG TIN LOGIN ĐƯỢC CẤT VÀO 1 NƠI MÀ MỌI TRANG CỦA USER NÀY CÙNG NHÌN THẤY, CÙNG SỬ DỤNG
//THÙNG SESSION NÀY LÂU DÀI HƠN MODEL 
//SESSION : MỌI TRANG ĐỀU ADD, D---ÙNG, THỜI GIAN MẶC ĐỊNH LÀ 30 PHÚT