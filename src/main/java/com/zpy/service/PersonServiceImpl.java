package com.zpy.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zpy.entity.User;
import com.zpy.repository.PersonRepository;
import com.zpy.repository.UserRepository;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Resource
	private PersonRepository personRepository;
	
	@Resource
	private StudentService studentService;

	@Resource
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public void save(String username, int age) {
		userRepository.save(new User(username));
		
		studentService.save(username, "201704190001", age);
		
		System.out.println(1/0);
	}

}
