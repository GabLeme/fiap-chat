package com.fiap.chat.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.chat.dto.Response;
import com.fiap.chat.entity.Calendar;
import com.fiap.chat.service.CalendarService;

@RestController
@RequestMapping("/chat/v1")
public class CalendarController {

	@Autowired
	private CalendarService calendarService;
	
	@PostMapping("/calendar")
	public ResponseEntity<Response<Calendar>> createOrUpdate(@Valid @RequestBody Calendar calendar, BindingResult result) {
		Response<Calendar> response = new Response<Calendar>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		Calendar calendarSave  = calendarService.createOrUpdate(calendar);

		response.setData(calendarSave);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/calendar/findByUserId")
	public Calendar findByUserId(@RequestParam Long userID) {
		return this.calendarService.getCalendarByUserID(userID);
	}
}
