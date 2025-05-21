package test.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import test.entity.User;
import test.model.UserRequest;

public interface UserService {

	Page<User> findAll(Integer pageNo);
	
	void addOrUpdateUser(UserRequest userRequest);
	
	List<User> getAll(Pageable pageable);
}
