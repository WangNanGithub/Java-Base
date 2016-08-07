package com.devil.designmodel.strategy.behavior;

public class MuteQuack implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("哑巴不能发声");
	}

}
