package com.spring.ioc.xml;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spring.ioc.xml.outside.Pojo;

public class OutsideTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws SQLException {
		
//		ApplicationContext atc = new ClassPathXmlApplicationContext("applicationContext-Outside.xml");
		ApplicationContext atc = new FileSystemXmlApplicationContext("src/com/spring/ioc/applicationContext-Outside.xml");
		
		DataSource dataSource =  (DataSource) atc.getBean("dataSource");
		System.out.println(dataSource.getConnection());
		
		Pojo pojo = (Pojo) atc.getBean("pojo");
		System.out.println(pojo);
		
		//PropertyPathFactoryBean
		System.out.println("name=" + atc.getBean("pojoPpropertyPath", Pojo.class).getName());
		System.out.println("age=" + atc.getBean("pojoPpropertyPath", Pojo.class).getAge());
		
		//FieldRetrievingFactoryBean
		System.out.println("name=" + atc.getBean("pojoFiledRetrieving", Pojo.class).getName());
		System.out.println("age=" + atc.getBean("pojoFiledRetrieving", Pojo.class).getAge());
		
		//MethodInvokingFactoryBean
		System.out.println("name=" + atc.getBean("pojoMethodInvoking", Pojo.class).getName());
		System.out.println("age=" + atc.getBean("pojoMethodInvoking", Pojo.class).getAge());
	}

}
