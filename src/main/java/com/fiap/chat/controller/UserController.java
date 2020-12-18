package com.fiap.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.chat.entity.User;
import com.fiap.chat.service.UserService;

@RestController
@RequestMapping("/chat/v1")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public User createOrUpdate(@RequestBody User user) {
		return this.userService.createOrUpdate(user);
	}
}
