package com.devil.designmodel.factory.factory;

import com.devil.designmodel.factory.pizza.CheesePizza;
import com.devil.designmodel.factory.pizza.ChinesePizza;
import com.devil.designmodel.factory.pizza.Pizza;
import com.devil.designmodel.factory.pizza.VeggiePizza;

public class ChineseFactory implements SimplePizzaFactory {

	@Override
	public Pizza createPizza(String type) {
		Pizza pizza = null;
		switch (type) {
		case "china":
			pizza = new ChinesePizza(); // 提供中国工厂特有的中国披萨
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
