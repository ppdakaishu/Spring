package com.spring.transaction.xml.service.impl;

import com.spring.transaction.xml.dao.BookShopDao;
import com.spring.transaction.xml.service.BookShopService;

public class BookShopServiceImpl implements BookShopService {

	private BookShopDao bookShopDao;

	@Override
	public void buyBook(String bookSerialNo, String userName, int gross) {
		//查询书的单价
		int unitPrice = bookShopDao.findBookPriceByBookSerialNo(bookSerialNo);
		//更新图书库存
		bookShopDao.updateBookRepertory(bookSerialNo, gross);
		//更新用户余额
		bookShopDao.updateUserBalance(userName, unitPrice, gross);
	}
	
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}
	
}
