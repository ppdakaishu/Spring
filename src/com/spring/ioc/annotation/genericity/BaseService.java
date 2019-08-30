package com.spring.ioc.annotation.genericity;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {

	@Autowired
	private BaseDao<T> baseDao;
	
	public void update() {
		System.out.println("update...");
		System.out.println(baseDao);
	}
	
}
