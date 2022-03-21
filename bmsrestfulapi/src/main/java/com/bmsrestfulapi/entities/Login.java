package com.bmsrestfulapi.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "login")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loginId;
	private Integer accountNo;
	private String password = "1234";
	@Column(columnDefinition = "boolean default false")
	private boolean isLogin = false;
	@Column(columnDefinition = "boolean default false")
	private boolean isVerified = false;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "userId") // owning side
	@JsonIgnoreProperties
	private User user;

	public Login() {
		super();

		// TODO Auto-generated constructor stub
	}
	
	

	public Login(User user, AccountInfo ai) {
		this.accountNo = ai.getAccountNo();
		this.password = "1234";
		this.isLogin = false;
		this.isVerified = false;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", accountNo=" + accountNo + ", password=" + password + ", isLogin="
				+ isLogin + ", isVerified=" + isVerified + ", userId=" + user.getUserId() + "]";
	}

}
