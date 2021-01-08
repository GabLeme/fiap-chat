package com.fiap.chat.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fiap.chat.dto.LoginDTO;
import com.fiap.chat.entity.User;
import com.fiap.chat.repository.UserRepository;
import com.sun.el.stream.Optional;

@SpringBootTest
public class UserServiceTest {

	@MockBean
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
}
