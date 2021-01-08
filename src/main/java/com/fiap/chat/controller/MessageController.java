package com.fiap.chat.controller;

import java.util.List;

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
import com.fiap.chat.entity.Message;
import com.fiap.chat.service.MessageService;

@RestController
@RequestMapping("/chat/v1")
public class MessageController {
	
	@Autowired
	private MessageService service;
	
	@DeleteMapping("/message/{messageId}")
	public ResponseEntity deleteMessage(@PathVariable(name = "messageId") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/message/{userConversationId}")
	public List<Message> findByUserConversationId(@PathVariable(name = "userConversationId") Long id) {
		return this.service.findByUserConv(id);
	}
	
	@PostMapping("/message")
	public ResponseEntity<Response<Message>> createOrUpdateMessage(@Valid @RequestBody Message m, BindingResult result) {
		Response<Message> response = new Response<Message>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		Message messageSave = service.createOrUpdate(m);

		response.setData(messageSave);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
}
