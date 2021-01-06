package com.fiap.chat.service;

import com.fiap.chat.entity.NonWorkingDay;

public interface NonWorkingDayService {
	public NonWorkingDay createOrUpdate(NonWorkingDay nonWorkingDay) throws Exception;
	public void delete(Long id);
}
