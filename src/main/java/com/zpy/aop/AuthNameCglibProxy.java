package com.zpy.aop;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class AuthNameCglibProxy implements MethodInterceptor {

	private String name;
	
	public AuthNameCglibProxy(String name) {
		this.setName(name);
	}
	
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		if(!"zhangsan".equals(this.name)) {
			System.out.println("you have no auth!" + "----" + arg1.getName());
			return null;
		}
		System.out.println("------------------" + arg1.getName() + "--------------" + arg3.getSuperName());
		return arg3.invokeSuper(arg0, arg2);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
