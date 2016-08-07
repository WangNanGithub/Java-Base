package com.devil.designmodel.strategy;

import com.devil.designmodel.strategy.behavior.FlyNoWay;
import com.devil.designmodel.strategy.behavior.Quack;

public class ModelDuck extends Duck {
	public ModelDuck() {
		flyBehavior = new FlyNoWay(); // 模型鸭子一开始不会飞
		quackBehavior = new Quack();
	}

	@Override
	public void display() {
		System.out.println("我是一只模型鸭");
	}
}
