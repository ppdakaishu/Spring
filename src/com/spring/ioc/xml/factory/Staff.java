package com.spring.ioc.xml.factory;

public class Staff {

	private String name;
	private double salary;
	
	public Staff(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public Staff() {
		
	}

	@Override
	public String toString() {
		return "Staff [name=" + name + ", salary=" + salary + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
