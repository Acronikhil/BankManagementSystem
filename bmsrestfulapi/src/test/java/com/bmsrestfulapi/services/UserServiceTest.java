/**
 * 
 */
package com.bmsrestfulapi.services;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.bmsrestfulapi.entities.User;

@SpringBootTest
class UserServiceTest {

	
	@BeforeEach
	void setUp() {
		User user = new User(1,"Indore","Sakshi",123,LocalDate.now(),8962132378L,"female");
		
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
