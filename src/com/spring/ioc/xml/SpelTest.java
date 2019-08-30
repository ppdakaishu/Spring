package com.spring.ioc.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spring.ioc.xml.spel.Address;
import com.spring.ioc.xml.spel.Company;
import com.spring.ioc.xml.spel.Staff;

public class SpelTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
//		ApplicationContext atc = new ClassPathXmlApplicationContext("applicationContext-Spel.xml");
		ApplicationContext atc = new FileSystemXmlApplicationContext("src/com/spring/ioc/applicationContext-Spel.xml");
		
		Address address = (Address) atc.getBean("address");
		System.out.println(address);
		
		Staff staff = (Staff) atc.getBean("staff");
		System.out.println(staff);
		
		Company company = (Company) atc.getBean("company");
		System.out.println(company);
		
	}

}
