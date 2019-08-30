package com.spring.aop.xml.impl;

import com.spring.aop.xml.Calculator;

public class CalculatorImpl implements Calculator {

	@Override
	public int add(int a, int b) {
		int result = a + b;
		return result;
	}

	@Override
	public int subtract(int a, int b) {
		int result = a - b;
		return result;
	}

	@Override
	public int multiply(int a, int b) {
		int result = a * b;
		return result;
	}

	@Override
	public int divide(int a, String b) {
		int result = a / Integer.parseInt(b);
		return result;
	}

}
