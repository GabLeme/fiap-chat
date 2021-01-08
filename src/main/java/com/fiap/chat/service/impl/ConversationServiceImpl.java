package com.fiap.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.chat.entity.Conversation;
import com.fiap.chat.repository.ConversationRepository;
import com.fiap.chat.service.ConversationService;

@Service
public class ConversationServiceImpl implements ConversationService {

	@Autowired
	private ConversationRepository repo;
	
	@Override
	public Conversation createOrUpdate(Conversation c) {
		return repo.save(c);
	}
}
