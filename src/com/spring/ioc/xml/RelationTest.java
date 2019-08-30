package com.spring.ioc.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spring.ioc.xml.autowire.Address;
import com.spring.ioc.xml.autowire.Company;

public class RelationTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
//		ApplicationContext atc = new ClassPathXmlApplicationContext("applicationContext-Relation.xml");
		ApplicationContext atc = new FileSystemXmlApplicationContext("src/com/spring/ioc/applicationContext-Relation.xml");
		
//		Address address1 = (Address) atc.getBean("address1");
//		System.out.println(address1);
		
		Address address2 = (Address) atc.getBean("address2");
		System.out.println(address2);
		
		Company company = (Company) atc.getBean("company");
		System.out.println(company);
		
	}

}
