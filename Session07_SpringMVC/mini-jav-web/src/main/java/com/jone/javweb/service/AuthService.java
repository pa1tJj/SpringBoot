package com.jone.javweb.service;

import org.springframework.stereotype.Service;

import com.jone.javweb.model.entity.Auth;
import com.jone.javweb.repository.AuthRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final AuthRepository authRepository;
	
	public void save(Auth auth) {
		authRepository.save(auth);
	}
	
	public Auth check(Auth auth) {
		Auth find = authRepository.findByPhoneAndPassword(auth.getPhone(), auth.getPassword());
		return find;
	}
}
