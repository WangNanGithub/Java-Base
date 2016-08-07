package com.devil.designmodel.strategy.behavior;

public class FlyWithWings implements FlyBehavior{

	@Override
	public void fly() {
		System.out.println("这个鸭子能飞");
	}

}
