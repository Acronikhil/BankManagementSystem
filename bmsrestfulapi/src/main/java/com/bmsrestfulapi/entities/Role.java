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
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	@Column(columnDefinition = "varchar(10) default 'user'")
	private String roleName = "user";
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "userId") // owning side
	@JsonIgnoreProperties
	private User user;

	public Role() {
		super();
	}

	public Role(User user) {
		this.roleName = "user";
		this.user = user;
	}

	public Role(Integer roleId, String roleName, User user) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.user = user;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "\nRole [roleId=" + roleId + ", roleName=" + roleName + ", userId=" + user.getUserId() + "]";
	}

}
