package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controller.LostPerson;
import entity.Person;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public abstract class Lost implements LostService {
	
	@Autowired
	private Lost LastKnownLocationDao;
	
	public <LastKnownLocationDao> List<Lost> fetchlostPerson(String lostPersonId, String homeStateId, String gender) {
		log.debug("The fetchPerson method was called with personId = {}," +
				"and provinceId = {}," + "and gender = {}", lostPersonId, 
				homeStateId, gender);

		return LastKnownLocationDao.fetchLostPerson(lostPersonId, homeStateId, gender);
	}

	public List<Lost> fetchLostPerson(String personId, String homeStateId, String gender) {
		// TODO Auto-generated method stub
		return null;
	}


}