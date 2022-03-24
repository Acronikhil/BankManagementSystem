package com.bmsrestfulapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bmsrestfulapi.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	// Retrieve Role from data store by userId returning role name
	@Query("select r.roleName from Role r where r.user.userId=:userId")
	public String getRole(@Param(value = "userId") Integer userId);

	// Retrieve all Role from data store by userId
	@Query("from Role r where r.user.userId=:userId")
	public Role getRoleObject(@Param(value = "userId") Integer userId);
}
