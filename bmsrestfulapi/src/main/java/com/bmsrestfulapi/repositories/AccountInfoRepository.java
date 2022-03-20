package com.bmsrestfulapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bmsrestfulapi.entities.AccountInfo;

public interface AccountInfoRepository extends JpaRepository<AccountInfo, Integer> {
	@Query("select ai.user.userId from AccountInfo ai where ai.accountNo=:accountNo")
	public Integer getUserIdByAccountNot(@Param(value="accountNo") Integer accountNo);
}
