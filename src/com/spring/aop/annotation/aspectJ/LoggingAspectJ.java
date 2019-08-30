package com.spring.aop.annotation.aspectJ;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//把这个类声明为一个切面 : 
//	1. 需要把该类放入 IOC 容器中. 加入注解 @Component
//	2. 在声明为一个切面. @Aspect 标识这个类是一个切面
@Order(1)
@Aspect
@Component
public class LoggingAspectJ {

	//定义一个方法, 用于声明切入点表达式. 
	//一般该方法中再不需要添加其他的代码
	@Pointcut("execution(* com.spring.aop.annotation.*.*(..))")
	public void declareJoinPointExpression() {}
	
	//声明该方法是一个 **前置通知** : 在目标方法执行之前执行
	//execution : 执行, 括号中为AspectJ的表达式.
	//第一个 * : 任意修饰符及任意返回值, 指定修饰符及返回值可写为 public int. 
	//第二个 * : 指定包下的所有类.		第三个 * : 指定类下的所有方法. 
	//.. : 参数通配符. 即参数任意
	@Before("declareJoinPointExpression()")
	public void beforeMethodLogger(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method [ " + methodName + " ] begin whit " + args);
	}
	
	//声明该方法是一个 **后置通知** : 在目标方法执行完之后执行( 无论该方法是否发生异常 )
	//后置通知不能访问方法返回值
	@After("declareJoinPointExpression()")
	public void afterMethodLogger(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method [ " + methodName + " ] end with " + args);
	}
	
	//声明该方法是一个 **返回通知** : 在目标方法正常结束后执行
	//返回通知可以访问方法返回值
	@AfterReturning(value = "declareJoinPointExpression()",returning = "result")
	public void afterMethodReturnLogger(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method [ " + methodName + " ] end with " + result);
	}
	
	//声明该方法是一个 **异常通知** : 在目标方法出现异常时执行
	//异常通知可以访问异常对象, 且可以指定在出现特定异常时再执行异常通知
	//Exception 也可以写为 Object, 在指定特定异常时可以写为 NumberFormatException 、 NullPointerException 等. 
	@AfterThrowing(value = "declareJoinPointExpression()",throwing = "ex")
	public void afterMethodThrowingLogger(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method [ " + methodName + " ] excetion : " + ex);
	}
	
	//声明该方法是一个 **环绕通知**, 环绕通知需要携带 ProceedingJoinPoint 类型的参数
	//环绕通知类似于动态代理的全过程, ProceedingJoinPoint 类型参数可以决定是否执行目标方法
	//环绕通知必须有返回值, 返回值即为目标方法的返回值
	/*
	@Around("execution(* com.spring.aop.annotation.*.*(.., ..))")
	public Object aroundMethod(ProceedingJoinPoint pj) {
		Object result = null;
		String methodName = pj.getSignature().getName();
		List<Object> args = Arrays.asList(pj.getArgs());
		try {
			//前置通知
			System.out.println("The method [ " + methodName + " ] begin whit " + args);
			//执行方法
			result = pj.proceed();
			//返回通知
			System.out.println("The method [ " + methodName + " ] end with " + result);
		} catch (Throwable e) {
			//异常通知
			System.out.println("The method [ " + methodName + " ] excetion : " + e);
			throw new RuntimeException(e);
		}
		//后置通知
		System.out.println("The method [ " + methodName + " ] end with " + args);
		return result;
	}
	*/
}
