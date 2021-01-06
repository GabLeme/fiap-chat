package com.fiap.chat.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.chat.dto.Response;
import com.fiap.chat.entity.Activity;
import com.fiap.chat.service.ActivityService;

@RestController
@RequestMapping("/chat/v1")
public class ActivityController {
	
	@Autowired
	private ActivityService activityService;
	
	@PostMapping("/activity")
	public ResponseEntity<Response<Activity>> createOrUpdate(@Valid @RequestBody Activity activity, BindingResult result) {
		Response<Activity> response = new Response<Activity>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		Activity activitySave  = activityService.createOrUpdate(activity);

		response.setData(activitySave);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@DeleteMapping("/activity/{id}")
	public ResponseEntity deleteById(@PathVariable(name = "id") Long id) {
		this.activityService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
