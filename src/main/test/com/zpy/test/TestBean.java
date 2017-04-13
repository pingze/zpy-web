package com.zpy.test;
import java.lang.reflect.Proxy;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zpy.aop.PersonCglibProxy;
import com.zpy.aop.UserInterceptor;
import com.zpy.entity.User;
import com.zpy.repository.PersonRepository;
import com.zpy.repository.UserDao;
import com.zpy.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:bean.xml"})
public class TestBean {

	@Resource
	private UserDao userDao;
	
	@Resource
	private UserService userService;
	
	@Test
	public void test() {
		//ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		
		//UserService userService = (UserService) ac.getBean("userService");
		
		userService.save(new User("zhangsan"));
		
		userService.saveByTaskExecutor(new User("lisi"));
	}
	
	@Test
	public void proxyTest() {
		UserInterceptor h = new UserInterceptor();
		h.setTarget(userDao);
		UserDao proxy = (UserDao)Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), h);
		proxy.save(new User());
	}
	
	@Test
	public void cglibProxyTest() {
		PersonCglibProxy pcp = new PersonCglibProxy();
		Enhancer e = new Enhancer();
		e.setSuperclass(PersonRepository.class);
		e.setCallback(pcp);
		
		PersonRepository proxy = (PersonRepository)e.create();
		proxy.getName("zhangsan");
		
	}
	
	@Test
	public void getUserTest() {
		System.out.println(userService.getUserById(3));
	}
}
