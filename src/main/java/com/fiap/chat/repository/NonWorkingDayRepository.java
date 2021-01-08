package com.fiap.chat.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.chat.entity.Calendar;
import com.fiap.chat.entity.NonWorkingDay;

@Repository
public interface NonWorkingDayRepository extends JpaRepository<NonWorkingDay, Long> {
	
	public Boolean existsBydiaNaoUtilAndCalendar(LocalDate diaNaoUtil, Calendar calendar);

}

