package com.zpy.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zpy.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:bean.xml"})
public class TestTransactional {

	@Resource
	private PersonService personService;
	
	@Test
	public void test() {
		try {
			personService.save("张三4", 23);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
