package com.jone.springredis;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final RedisTemplate<Object, Object> template;

	public String getUser(String name) {
		System.out.println("đã xuống database");
		template.opsForValue().set("user", name, 1, TimeUnit.MINUTES);// tạo key trong redis để lưu name với thời gian tồn tại của key là 1 phút
		return (String) template.opsForValue().get("user");
	}
}
