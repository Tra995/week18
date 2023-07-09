package dao;

import java.util.List;

import controller.LostPerson;

public interface LastKnownlocation {
	List<LostPerson> fetchLostPerson(String lostpersonId, String homeStateId, String gender);
}