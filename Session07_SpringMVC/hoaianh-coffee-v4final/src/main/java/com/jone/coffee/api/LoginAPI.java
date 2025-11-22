package com.jone.coffee.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jone.coffee.model.dto.AccountDTO;
import com.jone.coffee.service.AuthService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginAPI {
	private final AuthService authService;
	
	public LoginAPI(AuthService authService) {
		this.authService = authService;
	}
	
	@PostMapping("/do-login")
	public String getLogin(@Valid @ModelAttribute AccountDTO accountDTO, RedirectAttributes redirectAttributes,HttpSession session) {
		if(authService.login(accountDTO)) {
			session.setAttribute("role", accountDTO.getRole());
			return "redirect:/product";
		} else {
			return "redirect:/login";
		}
		
	}
}
