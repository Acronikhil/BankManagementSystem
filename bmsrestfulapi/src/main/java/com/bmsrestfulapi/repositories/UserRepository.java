package com.bmsrestfulapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bmsrestfulapi.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	/*
	 * select * from user u Inner Join login l on l.user.userId = u.userId where l.isVerified = 0;
	 */
	@Query("from User u Inner Join Login l on l.user.userId = u.userId where l.isVerified = 0")
    public List<User> getNotVerifiedUsers();
	
}
