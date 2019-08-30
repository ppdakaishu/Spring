package com.spring.ioc.xml.outside;

public class Pojo {

	//FiledRetrievingFactoryBean
	public static String NAMEFIELD = "TestFiledRetrievingFactoryBean_Name";
	public static String AGEFIELD = "TestFiledRetrievingFactoryBean_Age";
	
	//MethodInvokingFactoryBean
	public String getNameValue(String arg1, String arg2) { 
		return arg1 + arg2; 
	}
	
	public static String getAgeValue() { 
		return "TestMethodInvokingFactoryBean_Age"; 
	}
	
	//PropertyPathFactoryBean
	private String name;
	private String age;
	
	@Override
	public String toString() {
		return "Pojo [name=" + name + ", age=" + age + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}
