package com.devil.designmodel.factory.store;

import com.devil.designmodel.factory.pizza.HandPizza;
import com.devil.designmodel.factory.pizza.Pizza;

public class HandStylePizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String type) {
		Pizza pizza = null;
		switch (type) {
		case "hand":
			pizza = new HandPizza();
			break;
		default:
			break;
		}
		return pizza;
	}

}
