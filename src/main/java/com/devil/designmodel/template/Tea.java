package com.devil.designmodel.template;

public class Tea extends Beverage {

	@Override
	protected void brew() {
		System.out.println("放入茶叶");
	}

	@Override
	protected void addCondiments() {
		System.out.println("加入柠檬片");
	}

}
