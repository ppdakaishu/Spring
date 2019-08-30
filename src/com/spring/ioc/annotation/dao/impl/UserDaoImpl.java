package com.spring.ioc.annotation.dao.impl;

import org.springframework.stereotype.Repository;

import com.spring.ioc.annotation.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public void save() {
		System.out.println("UserDaoImpl... save...");
	}

}
