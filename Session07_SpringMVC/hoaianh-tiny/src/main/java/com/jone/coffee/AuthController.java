package com.jone.coffee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String getLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	@PostMapping("/do-login")
	public String getLogin(@RequestParam("phone") String phone, HttpSession session, RedirectAttributes redirectAttributes) {
		//session là cái thùng dành cho từng user khác nhau
		//chứa nhiều món đồ, dùng chung cho các page luôn
		//thông tin login hay cất ở đây, role cất ở đây
		if(phone.equals("09999")) {
			session.setAttribute("role", 1);
		} else {
			session.setAttribute("role", 2);
		}
		return "redirect:/products";
	}
	
	//HTTP: GIAO THỨC THEO STYLE STATELESS, KHÔNG NHỚ LÂU
	//REQUEST/RESPONSE XONG , QUÊN LUÔN NGƯỜI ĐÃ GỌI
	//CẦN CÓ KĨ THUẬT ĐỂ LƯU LẠI DẤU VẾT CỦA 1 USER: REQUEST LẦN TRƯỚC VÀ LẦN NÀY LÀ CÙNG 1 NGƯỜI
	
	@GetMapping("/products")
	public String getProducts(@RequestParam(name = "keyword", required = false) String keyword , Model model, HttpSession session) {
		Integer role = (Integer)session.getAttribute("role");
		if(role == null) {
			return "redirect:/login";
		}
		
		if(keyword != null && !keyword.isEmpty()) {
			model.addAttribute("result", keyword + " ===> đã tìm kiếm dưới database");
		} else {
			model.addAttribute("result", "chưa làm gì cả");
		}
		model.addAttribute("role", session.getAttribute("role"));
		return "products";
	}
}
