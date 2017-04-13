package com.zpy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zpy.entity.Student;
import com.zpy.repository.StudentRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:bean.xml"})
public class TestJpaRepository {

	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void testSave() {
		Student s = new Student();
		s.setName("小明");
		s.setAge(15);
		s.setCno("2017041300001");
		studentRepository.saveAndFlush(s);
	}
	
	@Test
	public void testGet() {
		System.out.println(studentRepository.findOne(2));
		System.out.println(studentRepository.findByName("小明"));
	}
}
