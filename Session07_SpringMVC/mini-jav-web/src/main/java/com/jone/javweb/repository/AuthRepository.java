package com.jone.javweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jone.javweb.model.entity.Auth;

public interface AuthRepository extends JpaRepository<Auth, Long>{

	public Auth findByPhoneAndPassword(String phone, String pasword);
}
