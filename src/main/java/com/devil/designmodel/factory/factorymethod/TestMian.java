package com.devil.designmodel.factory.factorymethod;

import com.devil.designmodel.factory.staticfactory.Pizza;

public class TestMian {
	public static void main(String[] args) {
		Factory factory = new ChinesePizzaFactory();
		Pizza pizza = factory.createPizza();

		Factory factory2 = new USPizzaFactory();
		Pizza pizza2 = factory2.createPizza();
	}
}
