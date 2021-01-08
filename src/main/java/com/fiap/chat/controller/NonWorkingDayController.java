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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.chat.dto.Response;
import com.fiap.chat.entity.Calendar;
import com.fiap.chat.entity.NonWorkingDay;
import com.fiap.chat.service.NonWorkingDayService;

@RestController
@RequestMapping("/chat/v1")
public class NonWorkingDayController {
	@Autowired
	private NonWorkingDayService nonWorkingDayService;
	
	@PostMapping("/dianaoutil")
	public ResponseEntity<Response<NonWorkingDay>> createOrUpdate(@Valid @RequestBody NonWorkingDay diaNaoUtil, BindingResult result) throws Exception {
		Response<NonWorkingDay> response = new Response<NonWorkingDay>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		NonWorkingDay nonWorkingDaySave  = nonWorkingDayService.createOrUpdate(diaNaoUtil);

		response.setData(nonWorkingDaySave);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@DeleteMapping("/dianaoutil/{id}")
	public ResponseEntity deleteById(@PathVariable(name = "id") Long id) {
		this.nonWorkingDayService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
