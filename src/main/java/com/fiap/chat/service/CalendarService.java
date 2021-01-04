package com.fiap.chat.service;


import com.fiap.chat.entity.Calendar;

public interface CalendarService {
	public Calendar createOrUpdate(Calendar c);
	public Calendar getCalendarByUserID(Long userID);
}
