package com.devil.designmodel.factory.store;

import com.devil.designmodel.factory.pizza.Pizza;

public abstract class PizzaStore {
	// 由于开加盟店，加盟店自己动手制作披萨而不是从工厂进口
	// SimplePizzaFactory factory;
	//
	// public PizzaStore(SimplePizzaFactory factory) {
	// // 通过不同的工厂创建（可能有不同种类工厂，中国披萨厂、美国披萨厂）
	// this.factory = factory;
	// }

	public Pizza orderPizza(String type) {
		Pizza pizza;
		pizza = createPizza(type);
		// 从工厂拿来披萨后，店员进行加工(打包，切片之类)
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}

	abstract Pizza createPizza(String type);
}
