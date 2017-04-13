package com.zpy.aop;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import com.zpy.repository.TableDao;

public class AuthCglibProxyFactory {

	public static TableDao getProxyInstance(String name) {
		Enhancer e = new Enhancer();
		e.setSuperclass(TableDao.class);
		e.setCallback(new AuthNameCglibProxy(name));
		
		return (TableDao) e.create();
	}
	
	public static TableDao getProxyFilterInstance(String name, int age) {
		Enhancer e = new Enhancer();
		e.setSuperclass(TableDao.class);
		e.setCallbacks(new Callback[]{new AuthNameCglibProxy(name), NoOp.INSTANCE, new AuthAgeCglibProxy(age)});
		e.setCallbackFilter(new AuthCglibFilter());
		
		return (TableDao) e.create();
	}
}
