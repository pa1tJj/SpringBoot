package com.jone.springredis.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.jone.springredis.dto.UserDTO;
import com.jone.springredis.entity.UserEntity;
import com.jone.springredis.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	
	@Cacheable(value = "user", key = "#userDTO.username")
	public UserDTO getLogin(UserDTO userDTO) {
		UserEntity userEntity = userRepository.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
		UserDTO dto = new UserDTO();
		dto.setUsername(userEntity.getUsername());
		dto.setPassword(userEntity.getPassword());
		return dto;
	}
}
