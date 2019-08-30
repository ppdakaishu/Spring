package com.spring.transaction.xml.dao;

public interface BookShopDao {
	
	//根据书号获取书的单价
	public int findBookPriceByBookSerialNo(String bookSerialNo);
	
	//更新书的库存
	public void updateBookRepertory(String bookSerialNo, int gross);
	
	//更新用户的余额
	public void updateUserBalance(String userId, int bookPrice, int gross);
	
}
