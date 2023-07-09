package service;

import java.util.List;

import controller.LostPerson;

public interface LostService {

	List<LostPerson> fetchPerson(String personId, String homeProvinceId, String gender);

}