package com.app.module.users;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.app.module.users.data.User;
import com.app.module.users.data.UserRepository;
import reactor.test.StepVerifier;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UsersApplicationTests {

	@Autowired
	UserRepository userRepository;
	
	@Order(1)
	@Test
	void contextLoads() {
	}

	@Order(2)
	@Test
	void testCount(){
		StepVerifier.create(
			userRepository.count().log()
		)
		.expectNext(Long.valueOf(0))
		.verifyComplete();
	}
}
