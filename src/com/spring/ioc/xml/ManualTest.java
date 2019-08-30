package com.spring.ioc.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spring.ioc.xml.manual.Company;
import com.spring.ioc.xml.manual.DataSource;
import com.spring.ioc.xml.manual.HelloWorld;
import com.spring.ioc.xml.manual.Staff;

public class ManualTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		/*
		//1. 创建 HelloWorld 对象, 
		HelloWorld helloWorld = new HelloWorld();
		//2. 为 name 属性赋值
		helloWorld.setName("Cbw");
		*/
		
		//属性注入
		//1. 创建 spring IOC 容器
		//ApplicationContext : IOC 容器
		//ClassPathXmlApplicationContext : ApplicationContext 接口的实现类. 该实现类从类路径下加载配置文件
//		ApplicationContext atc = new ClassPathXmlApplicationContext("applicationContext-Manual.xml");
		ApplicationContext atc = new FileSystemXmlApplicationContext("src/com/spring/ioc/applicationContext-Manual.xml");
		
		//2. 从 IOC 容器中获取 Bean 实例
		//用 id 定位到 IOC 容器中的 bean : 
		HelloWorld helloWorld = (HelloWorld) atc.getBean("helloWorld");
		//用类型返回 IOC 容器中的 bean, 但要求 IOC 容器中必须只能有一个该类型的 bean : 
//		HelloWorld helloWorld =  atc.getBean(HelloWorld.class);
				
		//3. 调用 hello 方法
		helloWorld.hello();
		
		//构造器注入
		Staff staff = (Staff) atc.getBean("staff");
		System.out.println(staff);
		
		Company company = (Company) atc.getBean("company");
		System.out.println(company);
		
		DataSource dataSource = (DataSource) atc.getBean("properties");
		System.out.println(dataSource);
	}

}
