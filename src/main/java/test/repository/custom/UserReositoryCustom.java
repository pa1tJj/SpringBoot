package test.repository.custom;

import java.util.List;

import org.springframework.data.domain.Pageable;

import test.entity.User;
import test.model.UserSearchRequest;
import test.model.UserSearchResponse;

public interface UserReositoryCustom {
	List<User> findAlls(UserSearchRequest userSearchRequest, Pageable pageable);
	int countTotalItem(UserSearchResponse userSearchResponse);
}
