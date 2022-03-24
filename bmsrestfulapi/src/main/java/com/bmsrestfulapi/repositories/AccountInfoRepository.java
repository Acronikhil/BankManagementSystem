package com.bmsrestfulapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bmsrestfulapi.entities.AccountInfo;

@Repository
public interface AccountInfoRepository extends JpaRepository<AccountInfo, Integer> {
	/*
	 * Retrieve Account Information from the data store by account number,
	 * 
	 * @param account number value to search for
	 * 
	 * @return userId from account information
	 */
	@Query("select ai.user.userId from AccountInfo ai where ai.accountNo=:accountNo")
	public Integer getUserIdByAccountNo(@Param(value = "accountNo") Integer accountNo);

	// fetch current balance from account information by userId
	@Query("select ai.currentBalance from AccountInfo ai where ai.user.userId=:userId")
	public Integer getBalance(@Param(value = "userId") Integer userId);

	// fetch account information by account number
	@Query("from AccountInfo ai where ai.accountNo=:accountNo")
	public AccountInfo getAccountNo(@Param(value = "accountNo") Integer accountNo);

}
