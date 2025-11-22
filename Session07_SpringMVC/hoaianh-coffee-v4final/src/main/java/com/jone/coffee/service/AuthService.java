package com.jone.coffee.service;

import org.springframework.stereotype.Service;

import com.jone.coffee.entity.Account;
import com.jone.coffee.model.dto.AccountDTO;
import com.jone.coffee.repository.AuthRepository;

@Service
public class AuthService {

	private AuthRepository authRepository;
	
	public AuthService(AuthRepository authRepository) {
		this.authRepository = authRepository;
	}
	
	public void saveAccount(Account account) {
		authRepository.save(account);
	}
	
	public Boolean login(AccountDTO accountDTO) {
		Account account = authRepository.findByUsername(accountDTO.getUsername());
		accountDTO.setRole(account.getRole());
		if(account != null && account.getPassword().equals(accountDTO.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
	
	public Account authenticate(String userName, String password) {
		Account account = authRepository.findByUsername(userName);
		if(account == null) {
			return null; //TODO: return DTO thông báo usernaem không tồn tạo
		}
		
		if(!account.getPassword().equals(password)) {
			return null; //TODO: return DTO mang ý nghĩa đúng username nhưng sai mật khẩu
		}
		return account;
	}
}
