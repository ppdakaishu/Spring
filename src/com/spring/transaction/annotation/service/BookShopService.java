package com.spring.transaction.annotation.service;

public interface BookShopService {

	//购买图书
	public void buyBook(String bookSerialNo, String userName, int gross);
	
}
