package com.spring.transaction.xml.service.impl;

import java.util.List;

import com.spring.transaction.xml.service.BookShopBatchService;
import com.spring.transaction.xml.service.BookShopService;

public class BookShopBatchServiceImpl implements BookShopBatchService {
	
	private BookShopService bookShopService;
	
	@Override
	public void buyBooks(List<String> bookSerialNos, String userName, int gross) {
		for(String bookSerialNo : bookSerialNos) {
			bookShopService.buyBook(bookSerialNo, userName, gross);
		}
	}

	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}

}
