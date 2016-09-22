package com.devil.designmodel.template;

public class Coffee extends Beverage {

	@Override
	void brew() {
		System.out.println("添加咖啡");
	}

	@Override
	void addCondiments() {
		System.out.println("添加方糖");
	}

}
