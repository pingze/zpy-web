package com.zpy.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zpy.service.StudentService;
import com.zpy.service.TeacherService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:bean.xml"})
public class TestDynamicDataSource {

	@Resource
	private StudentService studentServiceImpl;
	
	@Resource
	private TeacherService teacherServiceImpl;
	
	@Test
	public void testMasterDataSource() {
		studentServiceImpl.save("小话", "2017041400003", 14);
	}
	
	@Test
	public void testSlaveDataSource() {
		teacherServiceImpl.save("张三丰", "2017041400002");
	}
}
