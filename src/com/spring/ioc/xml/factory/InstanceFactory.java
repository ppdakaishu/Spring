package com.spring.ioc.xml.factory;

import java.util.HashMap;
import java.util.Map;

/** 
 * 实例工厂 
 * 实例工厂的方法, 即先需要创建工厂本身, 再调用工厂的实例方法来返回 bean 的实例
 * */
public class InstanceFactory {

	private Map<String, Staff> map = null;
	
	public InstanceFactory() {
		if(map == null) {
			map = new HashMap<String, Staff>();
			map.put("chenbowen", new Staff("chenbowen", 9500));
			map.put("chendong", new Staff("chendong", 10500));
		}
	}
	
	public Staff getStaff(String name) {
		return map.get(name);
	}
	
}
