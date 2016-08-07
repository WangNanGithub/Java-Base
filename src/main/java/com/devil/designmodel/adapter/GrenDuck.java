package com.devil.designmodel.adapter;

public class GrenDuck implements Duck {

	@Override
	public void fly() {
		System.out.println("flying");
	}

	@Override
	public void call() {
		System.out.println(" Ga Ga");
	}

}
