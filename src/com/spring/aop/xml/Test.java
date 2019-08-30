package com.spring.aop.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		AbstractApplicationContext atc = new FileSystemXmlApplicationContext("src/com/spring/aop/applicationContext-xml.xml");
		
		Calculator calculator = (Calculator) atc.getBean("calculator");
		
		int result = calculator.divide(6, "3");
		System.out.println(result);
		
	}
	
}
