package com.jone.session_cookie;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private LocalTime time = LocalTime.now();
	
	public UserDTO getLogin(UserDTO userDTO) {
		UserEntity userEntity = userRepository.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
		System.out.println("đã xuống database lúc:" + time);
		UserDTO dto = new UserDTO();
		dto.setUsername(userEntity.getUsername());
		dto.setPassword(userEntity.getPassword());
		return dto;
	}
}
