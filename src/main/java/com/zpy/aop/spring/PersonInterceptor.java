package com.zpy.aop.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PersonInterceptor {

	@Before("execution(* com.zpy.repository.PersonRepositoryImpl.*(..))")
	public void before() {
		System.out.println("before");
	}
	
	@AfterReturning("execution(* com.zpy..*.*(..))")
	public void afterReturning() {
		System.out.println("afterReturning");
	}
	
	@Around("execution(* com.zpy.repository.PersonRepositoryImpl.get*(..))")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("before around");
		Object[] args = pjp.getArgs();
		System.out.println("param:" + args[0]);
		Object o = pjp.proceed(args);
		System.out.println("result:" + o);
		System.out.println("after around");
	}
}
