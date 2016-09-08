package com.devil.designmodel.factory.factorymethod;

import com.devil.designmodel.factory.model.ChinesePizza;
import com.devil.designmodel.factory.model.Pizza;

public class ChinesePizzaFactory implements Factory {
	private ChinesePizza pizza;

	@Override
	public Pizza createPizza() {
		System.out.println("工厂开始生产ChinesePizza");
		pizza = new ChinesePizza();
		pizza.addFlour();
		pizza.addWater();
		return (Pizza) pizza;
	}

}
