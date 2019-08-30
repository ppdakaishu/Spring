package com.spring.ioc.xml.factory;

import java.util.HashMap;
import java.util.Map;

/** 静态工厂 */
public class StaticFactory {

	public static Staff getStaff(String name) {
		Map<String, Staff> map = new HashMap<String, Staff>();
		map.put("chenbowen", new Staff("chenbowen", 9500));
		map.put("chendong", new Staff("chendong", 10500));
		return map.get(name);
	}
	
}
