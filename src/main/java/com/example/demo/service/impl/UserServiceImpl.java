package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.repository.UsersRepository;
import com.example.demo.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	private UsersRepository usersRepository;
	
	@Override
	public void deleteUser(Long id) {
		usersRepository.deleteById(id);
	}

}
