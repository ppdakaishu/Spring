package com.spring.transaction.annotation;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spring.transaction.annotation.controller.BookShopController;
import com.spring.transaction.annotation.dao.BookShopDao;

class TransactionTest {

	private BookShopController bookShopController = null;
	private BookShopDao bookShopDao = null;
	
	{
		@SuppressWarnings("resource")
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/com/spring/transaction/annotation/ApplicationContext-tx.xml");
		bookShopController = ctx.getBean(BookShopController.class);
		bookShopDao = ctx.getBean(BookShopDao.class);
	}
	
	@Test
	public void testBuyBook() throws SQLException {
		bookShopController.buyBook();
	}
	
	@Test
	public void testBuyBooks() throws SQLException {
		bookShopController.buyBooks();
	}
	
	void testFindBookPriceByBookSerialNo() throws SQLException {
		System.out.println(bookShopDao.findBookPriceByBookSerialNo("1001"));		
	}
	
	@Test
	void tesUpdateBookRepertory() throws SQLException {
		bookShopDao.updateBookRepertory("1001", 50);
	}
	
	@Test
	void tesUpdateUserBalance() throws SQLException {
		bookShopDao.updateUserBalance("CBW", 60, 10);
	}

}
