package com.jone.session_cookie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

	public UserEntity findByUsernameAndPassword(String userName, String password);
}
