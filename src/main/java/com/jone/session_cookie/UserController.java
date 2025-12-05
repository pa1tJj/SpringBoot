package com.jone.session_cookie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@PostMapping("/do-login")
	public String doLogin(@ModelAttribute UserDTO userDTO, HttpSession session, HttpServletResponse response) {
		UserDTO user = (UserDTO) session.getAttribute("user");
		if (user == null) {
			session.setAttribute("user", userService.getLogin(userDTO));
			Cookie cookie = new Cookie("user", String.valueOf(userDTO.getUsername()));//tạo 1 cookie với key=user và value=userDTO.getUsername()
			cookie.setHttpOnly(true);// ngăn javascript truy cập cookie
			cookie.setPath("/");
			cookie.setSecure(true); //chỉ gửi cookie qua HTTPS
			cookie.setMaxAge(10);
			response.addCookie(cookie);
		}
		return "redirect:/success";
	}

	@GetMapping("/success")
	public String getSuccess(Model model, HttpSession session) {
		UserDTO name = (UserDTO) session.getAttribute("user");
		model.addAttribute("name", name);
		return "success";
	}

	@GetMapping("/login")
	public String getLogin(Model model) {
		model.addAttribute("user", new UserDTO());
		return "login";
	}
}
