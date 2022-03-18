package com.bmsrestfulapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmsrestfulapi.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
