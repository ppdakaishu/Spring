package com.spring.ioc.xml.autowire;

public class Staff {

	private String name;
	private int age;
	
	@Override
	public String toString() {
		return "Staff [name=" + name + ", age=" + age + "]";
	}
	
	public Staff() {
		System.out.println("staff's constrctor...");
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
