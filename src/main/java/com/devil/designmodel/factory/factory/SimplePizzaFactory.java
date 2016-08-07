package com.devil.designmodel.factory.factory;

import com.devil.designmodel.factory.pizza.Pizza;

public interface SimplePizzaFactory {
	public Pizza createPizza(String type);
}
