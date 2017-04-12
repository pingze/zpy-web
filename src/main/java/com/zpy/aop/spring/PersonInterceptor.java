package com.zpy.aop.spring;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PersonInterceptor {

	@Before("execution(* com.zpy.dao.PersonDao.*(..))")
	public void before() {
		System.out.println("before");
	}
	
	@AfterReturning("execution(* com.zpy..*.*(..))")
	public void afterReturning() {
		System.out.println("afterReturning");
	}
}
