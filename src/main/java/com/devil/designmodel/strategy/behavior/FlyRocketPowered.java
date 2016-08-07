package com.devil.designmodel.strategy.behavior;

public class FlyRocketPowered implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("用火箭飞行");
	}

}
