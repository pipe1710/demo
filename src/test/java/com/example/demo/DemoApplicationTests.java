package com.example.demo;

import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	UserRepository userRepository;

	@Test
	void elRepositorioExiste() {
		System.out.println("perfet");
		assertNotNull(userRepository);
	}

	@Test
	@DisplayName("test para guardar usuarios")
	void testSaveUser(){
		User user1 = new User();
		user1.setEmail("agperezb@ufpso.edu.co");
		user1.setPassword("1256");
		user1.setFirstName("Angel");
		user1.setLastName("Perez");
		user1.setAddress("Rio de oro");
		user1.setPhoneNumber("3101");
//
		User savedUser = userRepository.save(user1);
//
//        User existUser = entityManager.find(User.class, savedUser.getId());
		System.out.println("adadf");

		assertEquals("12", "12");

	}

}
