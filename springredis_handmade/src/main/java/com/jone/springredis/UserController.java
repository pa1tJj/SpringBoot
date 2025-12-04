package com.jone.springredis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	private final RedisTemplate<Object, Object> template;


	@GetMapping("/test")
	public String getInfo(@RequestParam String name) {
		String result = userService.getUser(name);
		return "user:" + result + " |key:" + template.keys("user") + " | redis data:" + template.opsForValue().get("user");
				
	}
}
