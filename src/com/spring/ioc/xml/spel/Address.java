package com.spring.ioc.xml.spel;

public class Address {

	private String provice;
	private String city;
	
	@Override
	public String toString() {
		return "Address [provice=" + provice + ", city=" + city + "]";
	}
	
	public String getProvice() {
		return provice;
	}
	public void setProvice(String provice) {
		this.provice = provice;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
