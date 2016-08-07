package com.devil.designmodel.strategy.behavior;

public class Quack implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("嘎嘎叫");
	}

}
