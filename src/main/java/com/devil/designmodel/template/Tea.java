package com.devil.designmodel.template;

public class Tea extends CaffeineBeverage {

	@Override
	void brew() {
		System.out.println("放入茶叶");
	}

	@Override
	void addCondiments() {
		System.out.println("加入柠檬片");
	}

}
