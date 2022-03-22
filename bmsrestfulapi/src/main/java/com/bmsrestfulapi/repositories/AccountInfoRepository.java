package com.bmsrestfulapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bmsrestfulapi.entities.AccountInfo;


@Repository
public interface AccountInfoRepository extends JpaRepository<AccountInfo, Integer> {
	@Query("select ai.user.userId from AccountInfo ai where ai.accountNo=:accountNo")
	public Integer getUserIdByAccountNot(@Param(value="accountNo") Integer accountNo);
	
	@Query("select ai.currentBalance from AccountInfo ai where ai.user.userId=:userId")
	public Integer getBalance(@Param(value="userId") Integer userId);
	
	@Query("from AccountInfo ai where ai.accountNo=:accountNo")
	public AccountInfo getAccountNo(@Param(value = "accountNo") Integer accountNo);
	
}
