package com.bmsrestfulapi.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "UserId cannot be null")
	private Integer userId;
	private String address;
	private String name;
	private Integer pin;
	private LocalDate dob;
	private Long contactNo;
	private String gender;

	@OneToOne(mappedBy = "user",targetEntity = Role.class ,cascade = CascadeType.ALL, fetch = FetchType.LAZY) // inverse side
	private Role role;

	@OneToMany(mappedBy = "user",targetEntity = AccountInfo.class ,cascade = CascadeType.ALL,fetch = FetchType.LAZY) // inverse side
	private List<AccountInfo> accountList;

	@OneToOne(mappedBy = "user", targetEntity = Login.class , cascade = CascadeType.ALL, fetch = FetchType.LAZY) // inverse side
	private Login login;

	public User() {
		super();
	}

	public User(Integer userId, String address, String name, Integer pin, LocalDate dob, Long contactNo,
			String gender) {
		super();
		this.userId = userId;
		this.address = address;
		this.name = name;
		this.pin = pin;
		this.dob = dob;
		this.contactNo = contactNo;
		this.gender = gender;

	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	@JsonIgnore
	public Role getRole() {
		return role;
	}
	@JsonIgnore
	public void setRole(Role role) {
		this.role = role;
	}
	@JsonIgnore
	public List<AccountInfo> getAccountList() {
		return accountList;
	}
	@JsonIgnore
	public void setAccountList(List<AccountInfo> accountList) {
		this.accountList = accountList;
	}
	@JsonIgnore
	public Login getLogin() {
		return login;
	}
	@JsonIgnore
	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", address=" + address + ", name=" + name + ", pin=" + pin + ", dob=" + dob
				+ ", contactNo=" + contactNo + ", gender=" + gender + ", role=" + role + ", accountList=" + accountList
				+ ", login=" + login + "]";
	}

}
