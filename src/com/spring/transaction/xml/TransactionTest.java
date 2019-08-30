package com.spring.transaction.xml;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spring.transaction.xml.controller.BookShopController;


class TransactionTest {

	private BookShopController bookShopController = null;
	
	{
		@SuppressWarnings("resource")
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/com/spring/transaction/xml/ApplicationContext-tx.xml");
		bookShopController = ctx.getBean(BookShopController.class);
	}
	
	@Test
	public void testBuyBook() throws SQLException {
		bookShopController.buyBook();
	}

	@Test
	public void testBuyBooks() throws SQLException {
		bookShopController.buyBooks();
	}
	
}
