package com.jone.springredis.controller;

import java.util.Set;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jone.springredis.dto.UserDTO;
import com.jone.springredis.service.RedisService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TestController {
	private final RedisService  redisService;
	private final RedisTemplate<Object, Object> template;

	@GetMapping("/test")
	public String getRedis(@RequestBody UserDTO userDTO) {
		UserDTO result = redisService.getUser(userDTO);
		Set<Object> redisKey = template.keys("user"); //lấy ra tên của KEY
        Object value = template.opsForValue().get("user"); //lây ra dữ liêu được lưu trữ với key là "user"

        return "Service returned: " + result + 
               "\n Redis key: " + redisKey +
               "\n Redis value: " + value;
	}
	
}
