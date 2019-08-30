package com.spring.aop.xml.aspectJ;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;

public class ValidAspectJ {

	public void validArgs(JoinPoint joinPoint) {
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		for(int i = 0; i < args.size(); i++) {
			String arg = args.get(i).toString();
			if(!arg.matches("^[1-9]\\d*$")) {
				System.out.println("Invalid parameter : " + arg);
			}
		}
		System.out.println(args);
	}
	
}
