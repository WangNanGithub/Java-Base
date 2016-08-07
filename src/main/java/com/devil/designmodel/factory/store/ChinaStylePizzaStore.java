package com.devil.designmodel.factory.store;

import com.devil.designmodel.factory.factory.ChineseFactory;
import com.devil.designmodel.factory.factory.SimplePizzaFactory;
import com.devil.designmodel.factory.pizza.Pizza;

public class ChinaStylePizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String type) {
		SimplePizzaFactory factory = new ChineseFactory();
		return factory.createPizza("china");
	}

}
