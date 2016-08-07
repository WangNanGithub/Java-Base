package com.devil.designmodel.strategy.behavior;

public class Squeak implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("吱吱叫");
	}

}
