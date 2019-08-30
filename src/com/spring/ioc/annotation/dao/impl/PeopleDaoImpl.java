package com.spring.ioc.annotation.dao.impl;

import org.springframework.stereotype.Repository;

import com.spring.ioc.annotation.dao.UserDao;

@Repository
public class PeopleDaoImpl implements UserDao {

	@Override
	public void save() {
		System.out.println("PeopleDaoImpl... save...");
	}

}
