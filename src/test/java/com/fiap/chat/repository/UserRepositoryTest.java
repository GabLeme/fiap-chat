package com.fiap.chat.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fiap.chat.dto.Response;
import com.fiap.chat.entity.Login;
import com.fiap.chat.entity.User;

@SpringBootTest
public class UserRepositoryTest {
	
	private static final String EMAIL = "email@teste.com";
	
	@Autowired
	UserRepository userRepository;
	
	@AfterEach
	public void tearDown() {
		userRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Save user in db")
	public void testSave() {
		User u = new User();
		Login login = new Login();
		login.setEmail("outroteste@email.com");
		login.setPassword("12345678");
		u.setCpf("48606719889");
		u.setLogin(login);

		
		User response = userRepository.save(u);
		
		assertNotNull(response);
	}
	
}
