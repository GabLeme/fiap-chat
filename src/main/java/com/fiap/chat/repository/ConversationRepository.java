package com.fiap.chat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.chat.entity.Conversation;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long>{

	
	//List<Conversation> findConversationsByUsersIdIn()
}
