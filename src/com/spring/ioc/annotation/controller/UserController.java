package com.spring.ioc.annotation.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.ioc.annotation.service.UserService;
import com.spring.ioc.annotation.service.impl.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
//	@Resource
	private UserService userService;
	
	public void save() {
		System.out.println("UserController... save...");
		userService.save();
	}
	
}
