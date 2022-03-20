package com.bmsrestfulapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bmsrestfulapi.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	@Query("select r.roleName from Role r where r.user.userId=:userId")
    public String getRole(@Param(value="userId") Integer UserId);
}
