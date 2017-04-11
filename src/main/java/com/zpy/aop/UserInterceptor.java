package com.zpy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserInterceptor implements InvocationHandler{

	private Object target;
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(method.getName() + "start.");
		method.invoke(target, args);
		System.out.println(method.getName() + "end.");
		return null;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}
	
}
