package com.devil.designmodel.decorate;

/**
 * 
 * @author ys
 * @date 2016年4月21日 下午4:06:29
 * @version 1.0.0
 *
 *          综合型咖啡
 */
public class HouseBlend extends Beverage {
	public HouseBlend() {
		description = "HouseBlend";
	}

	@Override
	public double cost() {
		return .89;
	}
}
