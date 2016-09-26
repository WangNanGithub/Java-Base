package com.devil.designmodel.builder;

/**
 * 生成器的具体实现
 */
public class HouseBuilder implements Builder {

	private House house = new House();

	@Override
	public void bed(int bed) {
		house.bed = bed;
	}

	@Override
	public void door(int door) {
		house.door = door;
	}

	@Override
	public void window(int window) {
		house.window = window;
	}

	@Override
	public void roof(int roof) {
		house.roof = roof;
	}

	@Override
	public void wall(int wall) {
		house.wall = wall;
	}

	@Override
	public House getProduct() {
		return house;
	}

}
