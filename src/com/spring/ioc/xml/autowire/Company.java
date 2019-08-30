package com.spring.ioc.xml.autowire;

public class Company {

	private String name;
	private Address address;
	private Staff staff;
	
	@Override
	public String toString() {
		return "Company [name=" + name + ", address=" + address + ", staff=" + staff + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
}
