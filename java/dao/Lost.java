package dao;

import java.util.List;

import lostapplication.Person;

public interface Lost {
	List<Person> fetchPerson(String personId, String homeStateId, String gender);
}