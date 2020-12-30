package com.fiap.chat.service;

import java.util.List;

import com.fiap.chat.entity.Message;

public interface MessageService {
	public Message createOrUpdate(Message m);
	public void delete(Long id);
	public List<Message> findByUserConv(Long userConvId);
}
