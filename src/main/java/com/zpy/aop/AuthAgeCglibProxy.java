package com.zpy.aop;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class AuthAgeCglibProxy implements MethodInterceptor {

	private int age;
	
	public AuthAgeCglibProxy(int age) {
		this.age = age;
	}
	
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		if(this.age < 18) {
			System.out.println("age is not suitable" + "--------" + arg1.getName());
			return null;
		}
		return arg3.invokeSuper(arg0, arg2);
	}

}
