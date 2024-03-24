package com.app.module.users;

import java.util.ArrayList;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.app.module.users.data.IUserService;
import reactor.test.StepVerifier;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReadTests {

    @Autowired
	IUserService userService;

	@Order(1)
	@Test
	void testCount(){
		StepVerifier.create(
			userService.getUsersQuantity()
		)
		.expectNext(Long.valueOf(1))
		.verifyComplete();
	}

	@Order(2)
	@Test
	void testUserService1(){

		StepVerifier.create(
			userService.getAllUsersWithRol().log()
		)
		.expectNext(new ArrayList<>())
		.verifyComplete();
	}
    
}
