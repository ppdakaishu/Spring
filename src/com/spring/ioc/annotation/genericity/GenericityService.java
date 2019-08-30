package com.spring.ioc.annotation.genericity;

import org.springframework.stereotype.Service;

import com.spring.ioc.annotation.entity.User;

@Service
public class GenericityService extends BaseService<User> {

}
