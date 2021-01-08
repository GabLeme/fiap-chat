package com.fiap.chat.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.fiap.chat.entity.UserConversation;

@Service
public interface UserConversationService {
	public UserConversation createOrUpdate(UserConversation u);
	public Set<UserConversation> findByUserId(Long id);
}
