package com.bmsrestfulapi.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "account_info")
public class AccountInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountNo;
	private Integer currentBalance = 0;
	private String accountType = "saving";
	// private Integer userId;

	@ManyToOne(cascade =CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	@JsonIgnoreProperties
	private User user;

	public AccountInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public AccountInfo(User user) {
		super();
		this.currentBalance = 0;
		this.accountType = "saving";
		this.user = user;
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
				+ accountType + ", userId=" + user.getUserId() + "]";
	}

}
