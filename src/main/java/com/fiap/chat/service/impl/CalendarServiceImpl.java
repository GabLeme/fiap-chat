package com.fiap.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.chat.entity.Calendar;
import com.fiap.chat.repository.CalendarRepository;
import com.fiap.chat.service.CalendarService;

@Service
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	private CalendarRepository repo;
	
	@Override
	public Calendar createOrUpdate(Calendar c) throws Exception {
		if(repo.existsByUser(c.getUser())) {
	        throw new Exception("Já existe calendário cadastrado para esse usuário.");
	    }
		return repo.save(c);
	}
	
	@Override
	public Calendar getCalendarByUserID(Long userID) {
		return this.repo.findByUserId(userID);
	}
	
}
