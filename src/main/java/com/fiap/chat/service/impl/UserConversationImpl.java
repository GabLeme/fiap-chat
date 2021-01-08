package com.fiap.chat.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.chat.entity.UserConversation;
import com.fiap.chat.repository.UserConversationRepository;
import com.fiap.chat.service.UserConversationService;

@Service
public class UserConversationImpl implements UserConversationService{

	@Autowired
	private UserConversationRepository repo;
	
	@Override
	public UserConversation createOrUpdate(UserConversation u) {
		return this.repo.save(u);
	}
	
	@Override
	public Set<UserConversation> findByUserId(Long id) {
		return this.repo.findByUserId(id);
	}

}
