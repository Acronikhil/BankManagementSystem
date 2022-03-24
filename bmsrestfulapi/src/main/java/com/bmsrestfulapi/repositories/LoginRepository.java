package com.bmsrestfulapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bmsrestfulapi.entities.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {
	@Query(" from Login l where l.accountNo=:accountNo and l.password=:password")
	public Login getCredentials(@Param(value = "accountNo") Integer accountNo,
			@Param(value = "password") String password);
	
	@Query(" from Login l where l.user.userId=:userId")
	public Login getLoginById(@Param(value = "userId") Integer userId);
	

}
