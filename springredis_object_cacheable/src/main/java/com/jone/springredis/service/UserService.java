package com.jone.springredis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.jone.springredis.dto.UserDTO;
import com.jone.springredis.entity.UserEntity;
import com.jone.springredis.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	@Cacheable(value = "user", key = "#id") // dữ liệu sẽ được tự động lưu vào redis (với key=user::2) nếu đã config
											// Redis còn không sẽ chỉ lưu vào spring cache
	public List<UserDTO> getLogin(Long id) {
		List<UserEntity> entities = userRepository.findAll();
		System.out.println("đã xuống tầng databbase");
		List<UserDTO> result = new ArrayList<UserDTO>();
		for (UserEntity userEntity : entities) {
			UserDTO dto = new UserDTO();
			dto.setId(userEntity.getId());
			dto.setUsername(userEntity.getUsername());
			dto.setPassword(userEntity.getPassword());
			dto.setFirstname(userEntity.getFirstname());
			dto.setLastname(userEntity.getLastname());
			result.add(dto);
		}
		return result;
	}
}
