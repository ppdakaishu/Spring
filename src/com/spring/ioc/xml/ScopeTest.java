package com.spring.ioc.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spring.ioc.xml.autowire.Staff;

public class ScopeTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
//		ApplicationContext atc = new ClassPathXmlApplicationContext("applicationContext-Scope.xml");
		ApplicationContext atc = new FileSystemXmlApplicationContext("src/com/spring/ioc/applicationContext-Scope.xml");
		
		Staff staff1 = (Staff) atc.getBean("staff");
		Staff staff2 = (Staff) atc.getBean("staff");
		
		System.out.println(staff1 == staff2);
		
	}

}
