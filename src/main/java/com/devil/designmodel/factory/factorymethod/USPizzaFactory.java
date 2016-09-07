package com.devil.designmodel.factory.factorymethod;

import com.devil.designmodel.factory.staticfactory.Pizza;
import com.devil.designmodel.factory.staticfactory.USPizza;

public class USPizzaFactory implements Factory {
	private USPizza pizza;

	@Override
	public Pizza createPizza() {
		System.out.println("工厂开始生产USPizza");
		pizza = new USPizza();
		pizza.addFlour();
		pizza.addWater();
		return (Pizza) pizza;
	}

}
