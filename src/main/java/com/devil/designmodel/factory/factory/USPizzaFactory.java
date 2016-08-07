package com.devil.designmodel.factory.factory;

import com.devil.designmodel.factory.pizza.CheesePizza;
import com.devil.designmodel.factory.pizza.Pizza;
import com.devil.designmodel.factory.pizza.USPizza;
import com.devil.designmodel.factory.pizza.VeggiePizza;

public class USPizzaFactory implements SimplePizzaFactory {

	@Override
	public Pizza createPizza(String type) {
		Pizza pizza = null;
		switch (type) {
		case "US":
			pizza = new USPizza(); // 提供美国工厂特有的美国披萨
			break;
		case "cheese":
			pizza = new CheesePizza();
			break;
		case "veggie":
			pizza = new VeggiePizza();
			break;
		default:
			break;
		}
		return pizza;
	}

}
