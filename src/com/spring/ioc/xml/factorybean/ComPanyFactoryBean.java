package com.spring.ioc.xml.factorybean;

import org.springframework.beans.factory.FactoryBean;

/** 自定义 FactoryBean 需要实现 FactoryBean 接口 */
public class ComPanyFactoryBean implements FactoryBean<Company> {

	@Override
	public Company getObject() throws Exception {
		Company company = new Company();
		company.setName("yinzhijie");
		company.setAddress("shenzhen");
		return company;
	}

	@Override
	public Class<?> getObjectType() {
		return Company.class;
	}

}
