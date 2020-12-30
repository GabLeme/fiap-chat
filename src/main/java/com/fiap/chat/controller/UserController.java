package com.fiap.chat.controller;

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

import com.fiap.chat.dto.LoginDTO;
import com.fiap.chat.dto.Response;
import com.fiap.chat.entity.User;
import com.fiap.chat.service.UserService;

@RestController
@RequestMapping("/chat/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public ResponseEntity<Response<User>> createOrUpdate(@Valid @RequestBody User user, BindingResult result) {
		Response<User> response = new Response<User>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		User userSave = userService.createOrUpdate(user);

		response.setData(userSave);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PostMapping("/user/login")
	public ResponseEntity<User> login(@RequestBody LoginDTO login) {
		return ResponseEntity.ok(this.userService.login(login));
	}

	@GetMapping("/user/{id}")
	public User findById(@PathVariable(name = "id") Long id) {
		return this.userService.findById(id);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity deleteById(@PathVariable(name = "id") Long id) {
		this.userService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
