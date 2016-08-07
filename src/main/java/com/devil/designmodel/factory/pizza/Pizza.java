package com.devil.designmodel.factory.pizza;

import java.util.ArrayList;

public abstract class Pizza {
	String name;
	String dough;
	String sauce;
	ArrayList<String> toppings = new ArrayList<>();

	public void prepare() {
		System.out.println("准备：" + name);
		System.out.println("揉粉团");
		System.out.println("加调料");
		System.out.println("添加装饰物：");
		for (int i = 0; i < toppings.size(); i++) {
			System.out.println("  " + toppings.get(i));
		}
	}

	public void bake(){
		System.out.println("烤制25分钟");
	}

	public void cut(){
		System.out.println("将披萨切片");
	}

	public void box(){
		System.out.println("将披萨打包");
	}
}
