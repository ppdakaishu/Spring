package com.spring.ioc.xml.manual;

public class Equipment {

	private String serialNumber;
	private String belongs;
	
	@Override
	public String toString() {
		return "Equipment [serialNumber=" + serialNumber + ", belongs=" + belongs + "]";
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getBelongs() {
		return belongs;
	}
	public void setBelongs(String belongs) {
		this.belongs = belongs;
	}
	
}
