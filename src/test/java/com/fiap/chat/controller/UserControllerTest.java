package com.fiap.chat.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fiap.chat.entity.User;
import com.fiap.chat.service.UserService;

public class UserControllerTest {
	private static final Long ID = 1L;
	private static final String EMAIL = "email@teste.com";
	private static final String NAME = "teste";
	private static final String PASSWORD = "123456";
	private static final String URL = "/user";
	
	@MockBean
	UserService userService;
	
	@Autowired
	MockMvc mvc;
//	
//	@Test
//	@DisplayName("Route to save an user in DB")
//	public void testSave() throws Exception {
//		
//		BDDMockito.given(userService.save(Mockito.any(User.class))).willReturn(this.getMockUser());
//		
//		mvc.perform(MockMvcRequestBuilders.post(URL).content(this.getJsonPayload(ID, EMAIL, NAME, PASSWORD))
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//		.andExpect(status().isCreated())
//		.andExpect(jsonPath("$.data.id").value(ID))
//	}
//	
//	public User getMockUser() {
//		User u = new User();
//		u.setId(ID);
//;
//		
//		return u;
//	}
}
