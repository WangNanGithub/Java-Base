package com.devil.designmodel.decorate;

/**
 * 
 * @author ys
 * @date 2016年4月21日 下午4:09:20
 * @version 1.0.0
 *
 *          饮料的基类
 */
public abstract class Beverage {
	String description = "Unknown Beverage";

	public String getDescription() {
		return description;
	}

	public abstract double cost();
}