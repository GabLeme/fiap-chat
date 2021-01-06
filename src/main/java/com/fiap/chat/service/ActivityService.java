package com.fiap.chat.service;

import com.fiap.chat.entity.Activity;

public interface ActivityService {
	public Activity createOrUpdate(Activity a);
	public void delete(Long id);
}
