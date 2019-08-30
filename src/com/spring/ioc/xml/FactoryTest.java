package com.spring.ioc.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spring.ioc.xml.factory.Staff;

public class FactoryTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
//		ApplicationContext atc = new ClassPathXmlApplicationContext("applicationContext-Factory.xml");
		ApplicationContext atc = new FileSystemXmlApplicationContext("src/com/spring/ioc/applicationContext-Factory.xml");
		
		Staff staff = (Staff) atc.getBean("staticFactory");
		System.out.println(staff);
		
		staff = (Staff) atc.getBean("staff");
		System.out.println(staff);
		
	}

}
