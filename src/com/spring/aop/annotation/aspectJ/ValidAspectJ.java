package com.spring.aop.annotation.aspectJ;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//使用 @Order 注解指定切面优先级.  值越小优先级越高
@Order(0)
@Aspect
@Component
public class ValidAspectJ {

	//不同包下, 需使用绝对路径 + . + 声明切入点表达式方法名.
	//如 : com.spring.aop.annotation.AspectJ.LoggingAspectJ.declareJoinPointExpression()
	@Before("LoggingAspectJ.declareJoinPointExpression()")
	public void validArgs(JoinPoint joinPoint) {
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		for(int i = 0; i < args.size(); i++) {
			String arg = args.get(i).toString();
			if(!arg.matches("^[1-9]\\d*$")) {
				System.out.println("Invalid parameter : " + arg);
//				throw new NumberFormatException("Invalid parameter : " + arg);
			}
		}
		System.out.println(args);
	}
	
}
