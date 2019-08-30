package com.spring.ioc.xml.cycle;

public class Cycle {

	private String cycle;

	@Override
	public String toString() {
		return "Cycle [cycle=" + cycle + "]";
	}

	public Cycle() {
		System.out.println("constructor...");
	}

	public void setCycle(String cycle) {
		System.out.println("set cycle...");
		this.cycle = cycle;
	}
	
	public void init() {
		System.out.println("init...");
	}
	
	public void destroy() {
		System.out.println("destroy...");
	}
	
}
