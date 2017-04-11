package com.zpy.aop;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class PersonCglibProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("------before------" + arg1.getName() + "-----superName:" + arg3.getSuperName());
		Object o = arg3.invokeSuper(arg0, arg2);
		System.out.println("------after------" + arg1.getName() + "-----superName:" + arg3.getSuperName());
		return o;
	}

}
