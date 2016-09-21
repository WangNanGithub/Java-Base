package com.devil.designmodel.strategy;

import com.devil.designmodel.strategy.behavior.FlyRocketPowered;

public class MiniTest {
	public static void main(String[] args) {
		Duck mallardDuck = new MallardDuck();
		mallardDuck.performFly();
		mallardDuck.performQuack();
		mallardDuck.display();
		
		Duck modelDuck = new ModelDuck();
		modelDuck.performFly();
		modelDuck.setFlyBehavior(new FlyRocketPowered());
		modelDuck.performFly();
		modelDuck.performQuack();
		modelDuck.display();
	}
}
