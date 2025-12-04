package com.jone.springredis.controller;

import java.util.List;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jone.springredis.dto.UserDTO;
import com.jone.springredis.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	private final RedisTemplate<Object, Object> template ;

	@GetMapping("/test")
	public String getUser(@RequestParam Long id) {
		List<UserDTO> user = userService.getLogin(id);
		String key = "user::" + id;
		Object value = template.opsForValue().get(key);
		return "result:" + user + " | key:" + key + " | redis value:" + value; 
	}
}
