package com.fiap.chat.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fiap.chat.entity.Conversation;
import com.fiap.chat.entity.Login;
import com.fiap.chat.entity.Message;
import com.fiap.chat.entity.User;
import com.fiap.chat.entity.UserConversation;
@SpringBootTest

public class ConversationRepositoryTest {
	
	@Autowired
	ConversationRepository repo;
	@Autowired
	MessageRepository mRepo;
	@Autowired
	UserConversationRepository uConvRepo;
	@Autowired
	UserRepository uRepo;
	
	
	@AfterEach
	public void tearDown() {
		mRepo.deleteAll();
		uConvRepo.deleteAll();
		repo.deleteAll();
		uRepo.deleteAll();
	}
	
	@Test
	@DisplayName("Create full conversation")
	public void setup() {
		User u = new User();
		Login l = new Login();
		u.setCpf("64668300802");
		l.setEmail("fulano@email.com");
		l.setPassword("12345678");
		u.setLogin(l);
		
		User uResponse = uRepo.save(u);
		
		Conversation c = new Conversation();
		c.setTitle("Grupao do ZAP");
	
		Conversation cResponse = repo.save(c);

		UserConversation uConv = new UserConversation();
		uConv.setConversation(cResponse);
		uConv.setUser(uResponse);
		UserConversation uConvResponse = uConvRepo.save(uConv);
		
		Message m = new Message();
		m.setText("Ola");
		m.setUserConversation(uConvResponse);
		Message mResponse = mRepo.save(m);
		
		assertNotNull(mResponse);
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
