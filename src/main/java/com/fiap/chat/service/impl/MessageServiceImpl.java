package com.fiap.chat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.chat.entity.Message;
import com.fiap.chat.repository.MessageRepository;
import com.fiap.chat.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageRepository repo;
	
	@Override
	public Message createOrUpdate(Message m) {
		return repo.save(m);
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Message> findByUserConv(Long userConvId) {
		return repo.findByUserConversationId(userConvId);
	}

}
