package com.spring.ioc.xml.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcess implements BeanPostProcessor {
	
	/**
	 * bean : bean 实例本身
	 * beanName : IOC 容器配置的 bean 的名字
	 * 返回值 ： 是实际上返回给用户的那个 bean
	 * 注意 : 可以在以上两个方法中修改返回的bean, 甚至返回一个新的 bean
	 * */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if("cycle".equals(beanName)) {
			System.out.println("postProcessBeforeInitialization : " + bean + ", " + beanName);
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if("cycle".equals(beanName)) {
			System.out.println("postProcessAfterInitialization : " + bean + ", " + beanName);
			Cycle cycle = new Cycle();
			cycle.setCycle("postProcessAfterInitialization_cycle");
			bean = cycle;
		}
		return bean;
	}
	
}
