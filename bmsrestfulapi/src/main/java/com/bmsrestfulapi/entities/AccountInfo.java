package com.bmsrestfulapi.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class AccountInfo {

	@Id
	private Integer accountNo;
	private Integer currentBalance;
	private String accountType;
	// private Integer userId;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "user_id", referencedColumnName = "userId")  
	@JsonIgnoreProperties
	private User user;   

	public AccountInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountInfo(Integer accountNo, Integer currentBalance, String accountType, User user) {
		super();
		this.accountNo = accountNo;
		this.currentBalance = currentBalance;
		this.accountType = accountType;
		this.user = user;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public Integer getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Integer currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "AccountInfo [accountNo=" + accountNo + ", currentBalance=" + currentBalance + ", accountType="
				+ accountType + ", user=" + user + "]";
	}

}
