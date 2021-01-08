package com.fiap.chat.service;

import org.springframework.stereotype.Service;

import com.fiap.chat.entity.Conversation;

@Service
public interface ConversationService{
	public Conversation createOrUpdate(Conversation c);
}
