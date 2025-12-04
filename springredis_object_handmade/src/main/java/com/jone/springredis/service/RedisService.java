package com.jone.springredis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.jone.springredis.dto.UserDTO;
import com.jone.springredis.entity.UserEntity;
import com.jone.springredis.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RedisService {

	private final RedisTemplate<Object, Object> template; // đây là RedisTemplate đã được config
	private final UserRepository userRepository;

	public UserDTO getUser(UserDTO userDTO) {
		String key = "user_" + userDTO.getId();
		UserDTO user = (UserDTO) template.opsForValue().get(key);
		if (user != null) {
			return user;
		} else {
			UserEntity userEntity = userRepository.findById(userDTO.getId()).get();
			System.out.println("thông báo đã xuống tầng database để lấy dữ liệu");
			UserDTO dto = new UserDTO();
			dto.setId(userEntity.getId());
			dto.setFirstname(userEntity.getFirstname());
			dto.setLastname(userEntity.getLastname());
			template.opsForValue().set("user_" + userDTO.getId(), dto); // câu lệnh thực hiện tạo một key "user" trong redis và lưu dữ liệu
														// có [ value=dto và key=user ]
			return dto;
		}

	}
}
