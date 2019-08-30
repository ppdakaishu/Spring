package com.spring.aop.xml.aspectJ;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspectJ {

	public void beforeMethodLogger(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method [ " + methodName + " ] begin whit " + args);
	}
	
	public void afterMethodLogger(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method [ " + methodName + " ] end with " + args);
	}
	
	public void afterMethodReturnLogger(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method [ " + methodName + " ] end with " + result);
	}
	
	public void afterMethodThrowingLogger(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method [ " + methodName + " ] excetion : " + ex);
	}
	
	public Object aroundMethod(ProceedingJoinPoint pj) {
		Object result = null;
		String methodName = pj.getSignature().getName();
		List<Object> args = Arrays.asList(pj.getArgs());
		try {
			//前置通知
			System.out.println("aroud : The method [ " + methodName + " ] begin whit " + args);
			//执行方法
			result = pj.proceed();
			//返回通知
			System.out.println("aroud : The method [ " + methodName + " ] end with " + result);
		} catch (Throwable e) {
			//异常通知
			System.out.println("aroud : The method [ " + methodName + " ] excetion : " + e);
			throw new RuntimeException(e);
		}
		//后置通知
		System.out.println("aroud : The method [ " + methodName + " ] end with " + args);
		return result;
	}
	
}
