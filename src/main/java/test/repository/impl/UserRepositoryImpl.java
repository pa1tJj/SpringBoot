package test.repository.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import test.entity.User;
import test.model.UserSearchRequest;
import test.model.UserSearchResponse;
import test.repository.UserRepository;
import test.repository.custom.UserReositoryCustom;

public class UserRepositoryImpl implements UserReositoryCustom{

	@Autowired
	EntityManager entityManager;
	
	public StringBuilder sql(UserSearchRequest userSearchRequest) {
		StringBuilder sql = new StringBuilder("select *from user u where 1 = 1 ");
		if(userSearchRequest.getUsername() != null) {
			sql.append("AND u.username LIKE '%" + "u." + userSearchRequest.getUsername()+ "%'" );
		}
		if(userSearchRequest.getPasswork() != null) {
			sql.append("AND u.username LIKE '%" + "u." + userSearchRequest.getPasswork()+ "%'" );
		}
		return sql;
	}
	
	@Override
	public List<User> findAlls(UserSearchRequest userSearchRequest, Pageable pageable) {
		Query query = entityManager.createNativeQuery(sql(userSearchRequest).toString(), User.class);
		return query.getResultList();
	}
	
	public String builQueryFilter(Long id) {
		String sql = "SELECT *FROM user u WHERE u.id =" + id;
		return sql;
	}

	@Override
	public int countTotalItem(UserSearchResponse userSearchResponse) {
		String sql = builQueryFilter(userSearchResponse.getId());
		Query query = entityManager.createNativeQuery(sql);
		return query.getResultList().size();
	}

}
