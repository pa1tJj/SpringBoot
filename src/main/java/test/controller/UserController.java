package test.controller;

import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import test.entity.User;
import test.model.UserDTO;
import test.model.UserSearchRequest;
import test.model.UserSearchResponse;
import test.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@GetMapping(value = "/admin/user-list")
	public ModelAndView getUser(@ModelAttribute("model") UserSearchRequest userSearchRequest, HttpRequest request) {
		ModelAndView mav = new ModelAndView("/admin/home");
		List<UserSearchResponse> users = userService.getAll(userSearchRequest, PageRequest.of(userSearchRequest.getPage(), userSearchRequest.getMaxPageItems()));
		UserSearchResponse userSearchResponse = new UserSearchResponse();
		userSearchResponse.setListResult(users);
		userSearchRequest.setTotalItems(userService.countTotalItem(users));
		mav.addObject("userList", userSearchResponse);
		return mav;
	}
	
	@GetMapping(value = "/admin/user-edit")
	public String addOrUpdateUser() {
		return "/admin/edit";
	}
	
	@GetMapping(value = "/admin/user-edit-{id}")
	public String addOrUpdateUser(Model model, @PathVariable("id") Long id) {
		UserDTO userDTO = userService.getUerResponse(id);
		model.addAttribute("getUserById",userDTO);
		return "/admin/edit";
	}
}
