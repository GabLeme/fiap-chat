package com.fiap.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.chat.entity.NonWorkingDay;
import com.fiap.chat.repository.NonWorkingDayRepository;
import com.fiap.chat.service.NonWorkingDayService;

@Service
public class NonWorkingDayServiceImpl implements NonWorkingDayService {

	@Autowired
	private NonWorkingDayRepository repo;
	
	@Override
	public NonWorkingDay createOrUpdate(NonWorkingDay nwd) throws Exception {
	 if(repo.existsBydiaNaoUtilAndCalendar(nwd.getDiaNaoUtil(), nwd.getCalendar())){
	      throw new Exception("Dia não util já cadastrado.");
	  }
		return repo.save(nwd);
	}
	
	@Override
	public void delete(Long id) {
		this.repo.deleteById(id);
	}
	
}
