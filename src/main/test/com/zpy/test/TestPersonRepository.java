package com.zpy.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zpy.entity.Person;
import com.zpy.repository.PersonRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:bean.xml"})
public class TestPersonRepository {

	private Logger log = LoggerFactory.getLogger(TestPersonRepository.class);
	
	@Resource
	private PersonRepository personRepository;
	
	@Test
	public void test() {
		personRepository.save(new Person("wangermazi", 21));
	}
	
	@Test
	public void queryTest() {
		System.out.println(personRepository.getPersonById(1));
	}
	
	@Test
	public void queryTest2() {
		System.out.println(personRepository.exists("zhangsan"));
	}
	
	@Test
	public void queryTest3() {
		log.error("start");
		System.out.println(personRepository.getPersonByIdOfJpa(1));
	}
}
