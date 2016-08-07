package com.devil.designmodel.strategy;

import com.devil.designmodel.strategy.behavior.FlyBehavior;
import com.devil.designmodel.strategy.behavior.QuackBehavior;

/**
 * 
 * @author ys
 * @date 2016年4月19日 下午5:15:40
 * @version 1.0.0
 *
 *          鸭子抽象父类
 */
public abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	// 加入行为的设置，之后可以随时修改行为
	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

	public Duck() {
	}

	// 执行鸭子行为
	public void performFly() {
		flyBehavior.fly();
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	public abstract void display();
	
	public void swim() {
		System.out.println("鸭子都会游泳！");
	}
}
