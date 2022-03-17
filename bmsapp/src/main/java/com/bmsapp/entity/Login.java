package com.bmsapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Login {

	@Id
	private Integer loginId;
	private Integer accountNo;
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "userId")  //owning side
	@JsonIgnoreProperties
	private User user;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(Integer loginId, Integer accountNo, String password) {
		super();
		this.loginId = loginId;
		this.accountNo = accountNo;
		this.password = password;
	}

	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", accountNo=" + accountNo + ", password=" + password + "]";
	}

}
