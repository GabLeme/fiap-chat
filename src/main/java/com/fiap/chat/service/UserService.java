package com.fiap.chat.service;

import org.springframework.stereotype.Service;

import com.fiap.chat.dto.LoginDTO;
import com.fiap.chat.entity.Login;
import com.fiap.chat.entity.User;

@Service
public interface UserService {
	public User findById(Long id);
	public User createOrUpdate(User user);	
	public void delete(Long id);
	public User login(LoginDTO login);
}
