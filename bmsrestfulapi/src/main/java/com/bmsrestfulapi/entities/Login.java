package com.bmsrestfulapi.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loginId;
	private Integer accountNo;
	private String password;
	@Column(columnDefinition = "boolean default false")
	private boolean isLogin;
	@Column(columnDefinition = "boolean default false")
	private boolean isVerified;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "userId") // owning side
	@JsonIgnoreProperties
	private User user;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(Integer loginId, Integer accountNo, String password, boolean isLogin, boolean isVerified) {
		super();
		this.loginId = loginId;
		this.accountNo = accountNo;
		this.password = password;
		this.isLogin = isLogin;
		this.isVerified = isVerified;
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

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", accountNo=" + accountNo + ", password=" + password + ", isLogin="
				+ isLogin + ", isVerified=" + isVerified + ", user=" + user + "]";
	}

}
