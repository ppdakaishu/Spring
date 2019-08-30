package com.spring.transaction.xml.service;

import java.util.List;

public interface BookShopBatchService {

	public void buyBooks(List<String> bookSerialNos, String userName, int gross);
	
}
