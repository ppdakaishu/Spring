package com.spring.ioc.xml.manual;

import java.util.List;
import java.util.Map;

public class Company {

	private String name;
	private String address;
	private Staff staff;
	private List<Equipment> equipments;
	private Map<String, Equipment> equipmentMap;
	
	@Override
	public String toString() {
		return "CompanyDto [name=" + name + ", address=" + address + ", staff=" + staff + ", equipments=" + equipments
				+ ", equipmentMap=" + equipmentMap + "]";
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
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public List<Equipment> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	public Map<String, Equipment> getEquipmentMap() {
		return equipmentMap;
	}
	public void setEquipmentMap(Map<String, Equipment> equipmentMap) {
		this.equipmentMap = equipmentMap;
	}
	
}
