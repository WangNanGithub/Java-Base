package com.devil.designmodel.builder;

import com.devil.designmodel.builder.pro.Bed;
import com.devil.designmodel.builder.pro.Door;
import com.devil.designmodel.builder.pro.Roof;
import com.devil.designmodel.builder.pro.Wall;

/**
 * 生成器的具体实现:别墅
 */
public class VillaHouseBuilder implements Builder {

	private House house = new House();

	@Override
	public void bed() {
		house.bed = new Bed("木床");
	}

	@Override
	public void door() {
		house.door = new Door("铁门");
	}

	@Override
	public void roof() {
		house.roof = new Roof("欧式带天窗屋顶");
	}

	@Override
	public void wall() {
		house.wall = new Wall("石墙");
	}

	@Override
	public House getProduct() {
		return house;
	}

}
