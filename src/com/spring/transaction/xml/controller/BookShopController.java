package com.spring.transaction.xml.controller;

import java.util.Arrays;
import java.util.List;

import com.spring.transaction.xml.service.BookShopBatchService;
import com.spring.transaction.xml.service.BookShopService;

public class BookShopController {

	private BookShopService bookShopService;
	private BookShopBatchService bookShopBatchService;
	
	public void buyBook() {
		String bookSerialNo = "1001"; //购买图书编号
		String userName = "CBW"; //购买用户
		int gross = 1; //购买数量
		bookShopService.buyBook(bookSerialNo, userName, gross);
	}
	
	public void buyBooks() {
		List<String> bookSerialNos = Arrays.asList("1001", "1002"); //购买图书编号
		String userName = "CBW"; //购买用户
		int gross = 1; //购买数量
		bookShopBatchService.buyBooks(bookSerialNos, userName, gross);
	}

	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}

	public void setBookShopBatchService(BookShopBatchService bookShopBatchService) {
		this.bookShopBatchService = bookShopBatchService;
	}
	
}
