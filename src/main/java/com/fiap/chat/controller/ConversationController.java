package com.fiap.chat.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.chat.dto.Response;
import com.fiap.chat.entity.Conversation;
import com.fiap.chat.entity.UserConversation;
import com.fiap.chat.service.ConversationService;
import com.fiap.chat.service.UserConversationService;

@RestController
@RequestMapping("/chat/v1")
public class ConversationController {

	@Autowired
	private ConversationService conversationService;

	@Autowired
	private UserConversationService userConversationService;
	
	@PostMapping("/conversations")
	public ResponseEntity<Response<Conversation>> createOrUpdate(@Valid @RequestBody Conversation conv, BindingResult result) {
		Response<Conversation> response = new Response<Conversation>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		Conversation convSave = conversationService.createOrUpdate(conv);

		response.setData(convSave);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PostMapping("/conversations/chat")
	public ResponseEntity<Response<UserConversation>> createOrUpdate(@Valid @RequestBody UserConversation uConv, BindingResult result) {
		Response<UserConversation> response = new Response<UserConversation>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		UserConversation uconvSave = userConversationService.createOrUpdate(uConv);

		response.setData(uconvSave);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/conversations/chat/{userid}")
	public ResponseEntity<Set<UserConversation>> getByUserId(@PathVariable(name = "userid") Long id) {
		return ResponseEntity.ok(this.userConversationService.findByUserId(id));
	}
	

}
