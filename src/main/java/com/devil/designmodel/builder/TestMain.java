package com.devil.designmodel.builder;

public class TestMain {
	public static void main(String[] args) {
		System.out.println("开始做木屋=======");
		Builder builder = new WoodHouseBuilder();
		Director director = new Director(builder);
		director.construct();
		System.out.println("开始做别墅=======");
		Builder builder2 = new VillaHouseBuilder();
		director = new Director(builder2);
		director.construct();
	}
}
