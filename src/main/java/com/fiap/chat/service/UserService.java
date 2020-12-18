package com.fiap.chat.service;

import org.springframework.stereotype.Service;

import com.fiap.chat.entity.User;

@Service
public interface UserService {
	public User findById(Long id);
	public User createOrUpdate(User user);	
}
