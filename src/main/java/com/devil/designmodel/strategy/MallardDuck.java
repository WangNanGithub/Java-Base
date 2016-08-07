package com.devil.designmodel.strategy;

import com.devil.designmodel.strategy.behavior.FlyWithWings;
import com.devil.designmodel.strategy.behavior.Quack;

/**
 * 
 * @author ys
 * @date 2016年4月19日 下午5:24:50
 * @version 1.0.0
 *
 *          野鸭
 */
public class MallardDuck extends Duck {

	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	@Override
	public void display() {
		System.out.println("我是一只野鸭");
	}
}
