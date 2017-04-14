package com.zpy.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zpy.entity.Teacher;
import com.zpy.repository.TeacherRepository;
import com.zpy.util.DataSource;

@Service("teacherServiceImpl")
public class TeacherServiceImpl implements TeacherService {

	@Resource
	private TeacherRepository teacherRepository;
	
	@Override
	@DataSource(name = "slave")
	public void save(String name, String tno) {

		teacherRepository.saveAndFlush(new Teacher(name, tno));
	}

}
