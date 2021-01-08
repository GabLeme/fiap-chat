package com.fiap.chat.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserConversationDTO {
	private List<Long> users;
	private Long conversationId;
	private String title;
}
