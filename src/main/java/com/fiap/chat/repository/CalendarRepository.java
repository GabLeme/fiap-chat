package com.fiap.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fiap.chat.entity.Calendar;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
	
	@Query("from Calendar c where c.user.id = :userId")
	public Calendar findByUserId(@Param("userId") Long userID);

}
