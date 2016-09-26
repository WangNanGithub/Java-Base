package com.devil.designmodel.builder;

public class TestMain {
	public static void main(String[] args) {
		Builder builder = new HouseBuilder();
		Director director = new Director(builder);
		director.construct();

		System.out.println(builder.getProduct().bed);
		System.out.println(builder.getProduct().door);
		System.out.println(builder.getProduct().window);
		System.out.println(builder.getProduct().roof);
		System.out.println(builder.getProduct().wall);
	}
}
