package com.spring.ioc.annotation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.ioc.annotation.dao.UserDao;
import com.spring.ioc.annotation.service.UserService;

@Service
public class UserServiceImpl implements UserService {

//	@Autowired
//	@Qualifier("peopleDaoImpl")
	private UserDao userDao;
	
	@Override
	public void save() {
		System.out.println("UserServiceImpl... save...");
		userDao.save();
	}

	@Autowired
	public void setUserDao(@Qualifier("peopleDaoImpl") UserDao userDao) {
		this.userDao = userDao;
	}
	
}
