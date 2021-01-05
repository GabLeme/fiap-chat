package com.fiap.chat.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fiap.chat.entity.Conversation;
@SpringBootTest

public class ConversationRepositoryTest {
	
	@Autowired
	ConversationRepository repo;
	
	@AfterEach
	public void tearDown() {
		repo.deleteAll();
	}
	
	@Test
	@DisplayName("create a conversation")
	public void testSave() {
		Conversation c = new Conversation();
		c.setTitle("Grupao do ZAP");
	
		Conversation response = repo.save(c);
		
		assertNotNull(response);
	}
	
	
}
