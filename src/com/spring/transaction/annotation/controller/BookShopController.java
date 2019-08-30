package com.spring.transaction.annotation.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.annotation.service.BookShopService;

@Controller
public class BookShopController {

	@Autowired
	private BookShopService bookShopService;
	
	public void buyBook() {
		String bookSerialNo = "1001"; //购买图书编号
		String userName = "CBW"; //购买用户
		int gross = 1; //购买数量
		bookShopService.buyBook(bookSerialNo, userName, gross);
	}
	
	@Transactional
	public void buyBooks() {
		List<String> bookSerialNos = Arrays.asList("1001", "1002"); //购买图书编号
		String userName = "CBW"; //购买用户
		int gross = 1; //购买数量
		for(String bookSerialNo : bookSerialNos) {
			bookShopService.buyBook(bookSerialNo, userName, gross);
		}
	}
	
}
