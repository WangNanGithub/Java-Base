package com.devil.designmodel.builder;

/**
 * 抽象生成器(Builder)：定义实体类属性的构建功能
 */
public interface Builder {
	
	public void bed();

	public void door();

	public void roof();

	public void wall();

	public House getProduct();
}
