package com.spring.ioc.annotation.genericity;

import org.springframework.stereotype.Repository;

import com.spring.ioc.annotation.entity.User;

@Repository
public class GenericityDao extends BaseDao<User> {

}
