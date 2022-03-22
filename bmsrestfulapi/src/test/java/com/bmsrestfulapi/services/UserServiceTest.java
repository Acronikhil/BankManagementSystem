package com.bmsrestfulapi.services;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bmsrestfulapi.entities.User;
import com.bmsrestfulapi.exceptions.UserNotCreatedException;
import com.bmsrestfulapi.repositories.UserRepository;

@SpringBootTest
class UserServiceTest {

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	private final User user = new User(1, "Indore", "2JuintTest2", 123, LocalDate.now(), 8962132378L, "female");

	@BeforeEach
	void setUp() {
		userRepository.save(user);
	}

	@Test
	void createUserTest() throws UserNotCreatedException {
		assertThrows(UserNotCreatedException.class, () -> userService.createUser(user));
	}

	@AfterEach
	void tearDown() {
		userRepository.delete(user);
	}

}
