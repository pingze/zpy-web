package com.zpy.aop.spring;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.zpy.util.DataSource;
import com.zpy.util.DynamicDataSourceHolder;

@Aspect
@Component
public class DynamicDataSourceInterceptor {

	@Around("execution(* com.zpy..*.*(..))")
	public void switchDataSource(ProceedingJoinPoint pjp) throws Throwable {
		Class<?> clazz = pjp.getTarget().getClass();
		Signature signature = pjp.getSignature();
		String methodName = signature.getName();
		Class<?>[] paramsTypes = ((MethodSignature) signature).getParameterTypes();
		
		Method method = clazz.getMethod(methodName, paramsTypes);
		if(method.isAnnotationPresent(DataSource.class)) {
			DataSource dataSource = method.getAnnotation(DataSource.class);
			DynamicDataSourceHolder.setDataSource(dataSource.name());
		}
		
		Object[] args = pjp.getArgs();
		pjp.proceed(args);
	}
}
