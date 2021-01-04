package com.fiap.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.chat.entity.Activity;
import com.fiap.chat.repository.ActivityRepository;
import com.fiap.chat.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {
	@Autowired
	private ActivityRepository repo;
	
	@Override
	public Activity createOrUpdate(Activity a) {
		return repo.save(a);
	}

}
