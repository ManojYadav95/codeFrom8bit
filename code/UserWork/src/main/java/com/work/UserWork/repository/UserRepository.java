package com.work.UserWork.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.work.UserWork.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{

	User findByUsername(String username);
	
	List<User> findByRole(String role);

}
