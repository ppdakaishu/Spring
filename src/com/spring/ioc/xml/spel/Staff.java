package com.spring.ioc.xml.spel;

public class Staff {

	private String name;
	private int age;
	private double salary;
	
	
	@Override
	public String toString() {
		return "Staff [name=" + name + ", age=" + age + ", salary=" + salary + "]";
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
