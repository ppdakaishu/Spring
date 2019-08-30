package com.spring.aop.annotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		AbstractApplicationContext atc = new FileSystemXmlApplicationContext("src/com/spring/aop/applicationContext-Annotation.xml");
		
		Calculator calculator = atc.getBean(Calculator.class);
		
		int result = calculator.divide(6, "3");
		System.out.println(result);
		
	}
	
}
