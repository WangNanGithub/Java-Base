package com.devil.designmodel.adapter;

public class TestMain {
	public static void main(String[] args) {
		HongkongPlug hk=new HongkongPlug();
		hk.threeHole();
		hk.twoHundredV();
		System.out.println("=========回到大陆");
		ClassAdapter ad =new ClassAdapter();
		ad.twoHole();
		ad.twoHundredTwentyV();
	}
}
