package com.fiap.chat.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fiap.chat.dto.LoginDTO;
import com.fiap.chat.dto.Response;
import com.fiap.chat.entity.Calendar;
import com.fiap.chat.entity.Activity;
import com.fiap.chat.entity.NonWorkingDay;
import com.fiap.chat.entity.Login;
import com.fiap.chat.entity.User;

@SpringBootTest
public class CalendarRepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	CalendarRepository calendarRepository;
	ActivityRepository activityRepository;
	NonWorkingDayRepository nonWorkingDayRepository;
	
	@BeforeEach
	public void setUp() {
		User u = new User();
		Login login = new Login();
		login.setEmail("anothertest@email.com");
		login.setPassword("12345678");
		u.setCpf("58284427915");
		u.setLogin(login);
		
		userRepository.save(u);
		
		Calendar c = new Calendar();
		c.setUser(u);
		
		calendarRepository.save(c);		
	}
	
	@AfterEach
	public void tearDown() {
		userRepository.deleteAll();
		calendarRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Save user calendar in db")
	public void testSave() {
		User u = new User();
		Login login = new Login();
		login.setEmail("outroteste@email.com");
		login.setPassword("12345678");
		u.setCpf("52247365604");
		u.setLogin(login);

		userRepository.save(u);
		
		Calendar c = new Calendar();
		c.setUser(u);
		
		Calendar response = calendarRepository.save(c);	
		
		assertNotNull(response);
	}
	
	@Test
	@DisplayName("Get User Calendar in DB")
	public void testGetCalendar() {
		User u = new User();
		Login login = new Login();
		login.setEmail("anothertest@email.com");
		login.setPassword("12345678");
		u.setCpf("52247365604");
		u.setLogin(login);
		
		userRepository.save(u);
		
		Calendar c = new Calendar();
		c.setUser(u);
		
		calendarRepository.save(c);	
		Calendar response = calendarRepository.findByUserId(u.getId());
		
		assertNotNull(response);
	}
	
	@Test
	@DisplayName("Get User Calendar in DB")
	public void testGetCalendarWithActivityAndNonWorkingDays() {
		User u = new User();
		Login login = new Login();
		login.setEmail("test@email.com");
		login.setPassword("12345678");
		u.setCpf("52247365604");
		u.setLogin(login);
		
		userRepository.save(u);
		
		Calendar c = new Calendar();
		c.setUser(u);
		
		calendarRepository.save(c);	
		
		Activity act1 = new Activity();
		act1.setCalendar(c);
		act1.setTitulo("Daily");
		act1.setDescricao("Reunião");
		act1.setDt_inicio(LocalDateTime.of(2021, 2, 8, 10, 30));
		act1.setDt_fim(LocalDateTime.of(2021, 2, 8, 11, 30));
		
		activityRepository.save(act1);	
		
		Activity act2 = new Activity();
		act2.setCalendar(c);
		act2.setTitulo("Sprint 9");
		act2.setDescricao("Reunião de alinhamento");
		act2.setDt_inicio(LocalDateTime.of(2021, 2, 10, 15, 30));
		act2.setDt_fim(LocalDateTime.of(2021, 2, 10, 16, 30));
		
		activityRepository.save(act2);
		
		NonWorkingDay nwd1 = new NonWorkingDay();
		nwd1.setCalendar(c);
		nwd1.setDiaNaoUtil(LocalDate.of(2021, 1, 25));
		
		nonWorkingDayRepository.save(nwd1);	
		
		NonWorkingDay nwd2 = new NonWorkingDay();
		nwd2.setCalendar(c);
		nwd2.setDiaNaoUtil(LocalDate.of(2021, 4, 21));
		
		nonWorkingDayRepository.save(nwd2);	
		
		Calendar response = calendarRepository.findByUserId(u.getId());
		
		assertNotNull(response);
	}
	
}
