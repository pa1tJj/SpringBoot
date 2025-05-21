package test.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import test.model.UserDTO;
import test.service.UserService;

@RestController
public class API {
	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public ModelAndView getUser() {
		ModelAndView mav = new ModelAndView();
		//List<UserDTO> result = userService.findAll();
		//mav.addObject("userList", result);
		return mav;
	}
}
