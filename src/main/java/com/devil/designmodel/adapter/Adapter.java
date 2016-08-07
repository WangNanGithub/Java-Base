package com.devil.designmodel.adapter;

public class Adapter {
	private Chicken chicken;

	public Adapter(Chicken chicken) {
		this.chicken = chicken;
	}

	// 叫声改变不了
	public void call() {
		chicken.call();
	}

	public void fly() {
		// 鸡要不停的跳，看起来像飞起来
		for (int i = 0; i < 10; i++) {
			chicken.jump();
		}
	}
}
