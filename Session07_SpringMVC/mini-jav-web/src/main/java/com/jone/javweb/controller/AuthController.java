package com.jone.javweb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jone.javweb.model.dto.MovieDTO;
import com.jone.javweb.model.entity.Auth;
import com.jone.javweb.service.AuthService;
import com.jone.javweb.service.MovieService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/phang-admin")
@RequiredArgsConstructor
public class AuthController {
	private final AuthService authService;

	@GetMapping("/login")
	public String getLogin(Model model) {
		model.addAttribute("auth", new Auth());
		return "login";
	}

	@PostMapping("/do-login")
	public String doLogin(@ModelAttribute Auth auth, RedirectAttributes redirectAttributes, HttpSession session) {
		Auth result = authService.check(auth);
		if (result != null) {
			session.setAttribute("auth", result);
			if(result.getRole().equals("user")) {
				return "redirect:/phangxxx/movist";
			} else {
				return "redirect:/phang/doing";
			}
		} else {
			return "redirect:/phang-admin/login";
		}

	}
	
	@GetMapping("/logout")
	public String getLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/phang-admin/login";
	}

}
