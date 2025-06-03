package test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.entity.User;
import test.repository.custom.UserReositoryCustom;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserReositoryCustom{
}
