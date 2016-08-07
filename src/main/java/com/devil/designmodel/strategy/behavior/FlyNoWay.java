package com.devil.designmodel.strategy.behavior;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("这个鸭子不能飞");
	}

}
