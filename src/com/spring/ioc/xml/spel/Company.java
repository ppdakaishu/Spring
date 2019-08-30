package com.spring.ioc.xml.spel;

public class Company {

	public static String CompanyUsedBean = "yinzhijie";
	
	private String name;
	//引用 address bean 的 provice + city 属性
	private String address;
	//根据 staff 的 salary 确定 staffRank : staffRank > 20000 ? T1 : T2
	private String staffRank;
	
	@Override
	public String toString() {
		return "Company [name=" + name + ", address=" + address + ", staffRank=" + staffRank + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStaffRank() {
		return staffRank;
	}
	public void setStaffRank(String staffRank) {
		this.staffRank = staffRank;
	}
	
}
