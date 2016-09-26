package com.devil.designmodel.builder;

/**
 * 抽象生成器(Builder)：定义实体类属性的构建功能
 */
public interface Builder {
	public void bed(int bed);

	public void door(int door);

	public void window(int window);

	public void roof(int roof);

	public void wall(int wall);

	public House getProduct();
}
