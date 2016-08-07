package com.devil.designmodel.decorate;

public class TestM {
	public static void main(String[] args) {
		Beverage be = new Espresso();
		System.out.println(be.getDescription() + "$" + be.cost());
		Beverage b2 = new HouseBlend();
		b2 = new Mocha(b2);
		System.out.println(b2.getDescription() + "$" + be.cost());
	}
}
