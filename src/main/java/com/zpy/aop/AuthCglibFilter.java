package com.zpy.aop;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.CallbackFilter;

public class AuthCglibFilter implements CallbackFilter {

	@Override
	public int accept(Method arg0) {
		if(arg0.getName().startsWith("query")) {
			return 1;
		}
		if(arg0.getName().startsWith("delete")) {
			return 2;
		}
		return 0;
	}

}
