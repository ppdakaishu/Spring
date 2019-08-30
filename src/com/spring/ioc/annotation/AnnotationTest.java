package com.spring.ioc.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spring.ioc.annotation.controller.UserController;
import com.spring.ioc.annotation.dao.impl.UserDaoImpl;
import com.spring.ioc.annotation.entity.User;
import com.spring.ioc.annotation.genericity.GenericityService;
import com.spring.ioc.annotation.service.impl.UserServiceImpl;

public class AnnotationTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
//		ApplicationContext atc = new ClassPathXmlApplicationContext("applicationContext-Annotation.xml");
		AbstractApplicationContext atc = new FileSystemXmlApplicationContext("src/com/spring/ioc/applicationContext-Annotation.xml");
		
//		User user = (User) atc.getBean("userEntity");
//		System.out.println(user);
//		
//		UserController userController = (UserController) atc.getBean("userController");
//		System.out.println(userController);
//		
//		UserServiceImpl userServiceImpl = (UserServiceImpl) atc.getBean("userServiceImpl");
//		System.out.println(userServiceImpl);
//		
//		UserDaoImpl userDaoImpl = (UserDaoImpl) atc.getBean("userDaoImpl");
//		System.out.println(userDaoImpl);
		
		UserController userController = (UserController) atc.getBean("userController");
		userController.save();
		
		GenericityService genericityService = (GenericityService) atc.getBean("genericityService");
		genericityService.update();
		
	}
	
}
