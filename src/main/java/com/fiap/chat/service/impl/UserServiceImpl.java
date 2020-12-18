package com.fiap.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.chat.entity.User;
import com.fiap.chat.repository.UserRepository;
import com.fiap.chat.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public User findById(Long id) {
		return this.repo.getOne(id);
	}

	@Override
	public User createOrUpdate(User user) {
		return this.repo.save(user);
	}

}
