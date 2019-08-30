package com.spring.transaction.entity;

//用户
public class User {

	//主键
	private Integer id;
	//用户名
	private String userName;
	//用户余额
	private Integer userBalance;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(Integer userBalance) {
		this.userBalance = userBalance;
	}
	
}
