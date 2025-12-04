package com.jone.springredis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jone.springredis.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
