package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import controller.LostPerson;
import dao.LastKnowLocation;
import dao.Lost;
import dao.Person;
import entity.Location;

@Service
public class LastKnownLocation<LastKnownLocationRequest> implements LostService {

	@Autowired
	private Lost LostDao;
	
	@Transactional
	public LastKnownLocation createPersonSighting(entity.LastKnowLocation LastKnownLocationRequest) {
		
		LastKnownLocation lastknownlocation = getLastKnownLocation(LastKnownLocationRequest);
		LostPerson lostperson = getLostPerson(LastKnownLocationRequest);
        System.out.println(LastKnownLocation.getLastKnownLocationPK());	
		return ((LastKnowLocation) LostDao).saveLastKnownLocation(lastknownlocation, lostperson);
		
	}


	}


