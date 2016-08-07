package com.devil.designmodel.adapter;

public class RedChicken implements Chicken {

	@Override
	public void jump() {
		System.out.println("jump a lot like fly");
	}

	@Override
	public void call() {
		System.out.println(" Wo Wo Wo");
	}

}
