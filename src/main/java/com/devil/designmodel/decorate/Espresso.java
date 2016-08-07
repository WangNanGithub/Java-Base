package com.devil.designmodel.decorate;

/**
 * 
 * @author ys
 * @date 2016年4月21日 下午4:05:24
 * @version 1.0.0
 *
 *          浓缩咖啡
 */
public class Espresso extends Beverage {

	public Espresso() {
		description = "Espresso";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 1.99;
	}

}
