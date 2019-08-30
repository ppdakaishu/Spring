package com.spring.ioc.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spring.ioc.xml.cycle.Cycle;

public class CycleTest {

	public static void main(String[] args) {
		
//		AbstractApplicationContext atc = new ClassPathXmlApplicationContext("applicationContext-Cycle.xml");
		AbstractApplicationContext atc = new FileSystemXmlApplicationContext("src/com/spring/ioc/applicationContext-Cycle.xml");
		
		Cycle cycle = (Cycle) atc.getBean("cycle");
		System.out.println(cycle);
		
		//关闭 IOC 容器
		atc.close();
	}

}
