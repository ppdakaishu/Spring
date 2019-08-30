package com.spring.ioc.xml.manual;

public class HelloWorld {

	private String name;

	public void hello() {
		System.out.println("hello : [ " + name + " ]");
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
