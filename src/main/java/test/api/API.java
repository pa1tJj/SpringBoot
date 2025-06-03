package test.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import test.model.UserRequest;
import test.service.UserService;

@RestController
@RequestMapping("/admin")
public class API {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ModelAndView getUser() {
		ModelAndView mav = new ModelAndView();
		//List<UserDTO> result = userService.findAll();
		//mav.addObject("userList", result);
		return mav;
	}
	
	@PostMapping("/user-edit")
	public void addOrUpdateUer(@ModelAttribute UserRequest userRequest) {
		userService.addOrUpdateUser(userRequest);
	}

}
