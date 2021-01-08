package com.fiap.chat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.chat.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
	public List<Message> findByUserConversationId(Long id);
}
