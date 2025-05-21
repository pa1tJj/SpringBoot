package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import test.entity.User;
import test.model.UserRequest;
import test.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@GetMapping(value = "/user-list")
	public String getUser(Model model, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
		Page<User> result = userService.findAll(pageNo);
		model.addAttribute("userList", result.getContent());
		model.addAttribute("totalPage", result.getTotalPages());
		return "home";
	}
	
	@PostMapping(value = "/user-edit")
	public String addOrUpdateUser(Model model, UserRequest userRequest) {
		userService.addOrUpdateUser(userRequest);
		return "edit";
	}
}
