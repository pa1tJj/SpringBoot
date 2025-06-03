package test.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import test.entity.User;
import test.model.UserDTO;
import test.model.UserRequest;
import test.model.UserSearchRequest;
import test.model.UserSearchResponse;

public interface UserService {

	Page<User> findAll(Integer pageNo);
	
	void addOrUpdateUser(UserRequest userRequest);
	
	List<UserSearchResponse> getAll(UserSearchRequest userSearchRequest, Pageable pageable);
	
	UserDTO getUerResponse(Long id);
	
	public int countTotalItem(List<UserSearchResponse> list);
}
