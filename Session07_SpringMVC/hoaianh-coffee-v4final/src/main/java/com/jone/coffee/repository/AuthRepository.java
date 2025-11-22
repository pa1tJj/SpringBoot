package com.jone.coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jone.coffee.entity.Account;

public interface AuthRepository extends JpaRepository<Account, Long> {
	public Account findByUsername(String username);

}
