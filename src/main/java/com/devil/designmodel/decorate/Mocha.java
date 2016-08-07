package com.devil.designmodel.decorate;

/**
 * 
 * @author ys
 * @date 2016年4月21日 下午4:09:56
 * @version 1.0.0
 *
 *          摩卡调料
 */
public class Mocha extends CondimentDecorator {
	Beverage beverage;

	public Mocha(Beverage beberage) {
		this.beverage = beberage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ",Mocha";
	}

	@Override
	public double cost() {
		return .2 + beverage.cost();
	}

}
