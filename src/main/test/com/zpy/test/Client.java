package com.zpy.test;

import org.junit.Test;

import com.zpy.aop.AuthCglibProxyFactory;
import com.zpy.dao.TableDao;

public class Client {

	@Test
	public void test2() {
		TableDao tableDao = new TableDao();
		doMethod(tableDao);
		
	}
	
	public static void doMethod(TableDao tableDao) {
		tableDao.create();
		tableDao.query();
		tableDao.update();
		tableDao.delete();
	}
	
	@Test
	public void test() {
		doMethod(AuthCglibProxyFactory.getProxyInstance("zhangsan"));
		System.out.println("-----------------------------");
		doMethod(AuthCglibProxyFactory.getProxyInstance("lisi"));
		System.out.println("-----------------------------");
	}
	
	@Test
	public void test3() {
		//doMethod(AuthCglibProxyFactory.getProxyFilterInstance("zhangsan"));
		//System.out.println("-----------------------------");
		doMethod(AuthCglibProxyFactory.getProxyFilterInstance("zhangsan", 17));
		System.out.println("-----------------------------");
	}
}
