package com.zpy.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zpy.entity.Student;
import com.zpy.repository.StudentRepository;
import com.zpy.util.DataSource;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentRepository studentRepository;
	
	@Override
	public String getStudentNameById(Integer id) {
		Student student = studentRepository.findOne(id);
		System.out.println(student);
		return student.getName();
	}

	@Override
	@DataSource(name = "master")
	@Transactional(propagation = Propagation.NESTED)
	public void save(String name, String cno, Integer age) {
		studentRepository.saveAndFlush(new Student(name, cno, age));
		//System.out.println(1/0);
	}

}
