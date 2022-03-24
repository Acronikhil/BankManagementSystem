package com.bmsrestfulapi.services;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bmsrestfulapi.entities.AccountInfo;
import com.bmsrestfulapi.entities.Login;
import com.bmsrestfulapi.entities.Role;
import com.bmsrestfulapi.entities.User;
import com.bmsrestfulapi.exceptions.InvalidCredentialsException;
import com.bmsrestfulapi.exceptions.InvalidLoginCredentialsException;
import com.bmsrestfulapi.exceptions.UserNotVerifiedException;
import com.bmsrestfulapi.repositories.UserRepository;

@SpringBootTest
class LoginServiceTest {

	@Autowired
	UserService userService;
	@Autowired
	LoginService loginService;

	@Autowired
	UserRepository userRepository;

	private final User user = new User(8, "Indore", "abcJuintTest", 123, LocalDate.now(), 8962132378L, "female");

	@BeforeEach
	void setUp() {
		userRepository.deleteAll();
		Role r = new Role(user);
		AccountInfo ai = new AccountInfo(user);
		List<AccountInfo> accountList = new ArrayList<>();
		accountList.add(ai);
		ai.setAccountNo(999);
		Login l = new Login(user, ai);

		user.setRole(r);
		user.setLogin(l);
		user.setAccountList(accountList);

		User u =userRepository.save(user);
		
		u.getLogin().setAccountNo(u.getAccountList().get(0).getAccountNo());
		
	}

	@Test
	void userLoginTest1() throws UserNotVerifiedException {
		assertThrows(UserNotVerifiedException.class, () -> loginService.login(999, "1234"));
	}

	@Test
	void userLoginTest2() throws InvalidCredentialsException {
		assertThrows(InvalidLoginCredentialsException.class, () -> loginService.login(12, "4"));
	}

	
	@Test
	void adminLoginTest1() throws UserNotVerifiedException {
		
		assertThrows(UserNotVerifiedException.class, () -> loginService.adminLogin(999, "1234"),"You are not admin, Please contact with BM.");
	}

	@Test
	void adminLoginTest2() throws InvalidCredentialsException {
		assertThrows(InvalidLoginCredentialsException.class, () -> loginService.adminLogin(12, "4"));
	}
	

	@AfterEach
	void tearDown() {
		System.out.println("Tearing Down");
		userRepository.deleteAll();
	}

}
