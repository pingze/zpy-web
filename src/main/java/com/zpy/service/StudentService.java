package com.zpy.service;

public interface StudentService {

	String getStudentNameById(Integer id);
	
	void save(String name, String cno, Integer age);
}
