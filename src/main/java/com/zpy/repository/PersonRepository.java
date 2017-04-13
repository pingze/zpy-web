package com.zpy.repository;

import com.zpy.entity.Person;

public interface PersonRepository {

	String getName(String name);
	
	int save(Person person);
	
	Person getPersonById(Integer id);
	
	boolean exists(String username);
}
