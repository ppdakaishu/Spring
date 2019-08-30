package com.spring.ioc.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spring.ioc.xml.autowire.Company;

public class AutowireTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
//		ApplicationContext atc = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext atc = new FileSystemXmlApplicationContext("src/com/spring/ioc/applicationContext-Autowire.xml");
		Company company = (Company) atc.getBean("company");
		System.out.println(company);
		
	}

}
