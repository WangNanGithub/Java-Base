package com.devil.designmodel.adapter;

public class Test {
	public static void main(String[] args) {
		Chicken chicken = new RedChicken();
		// 需求是鸭子不够了，拿鸡来冒充，所以有个适配器
		Adapter adapter = new Adapter(chicken);
		adapter.fly();
		adapter.call();
	}
}
