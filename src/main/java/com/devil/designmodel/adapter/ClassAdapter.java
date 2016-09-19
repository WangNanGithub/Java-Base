package com.devil.designmodel.adapter;

// 类适配器
public class ClassAdapter extends HongkongPlug implements MainlandPlug {

	@Override
	public void twoHundredTwentyV() {
		voltage = 220;
		rs += 2;
		twoHundredV();
	}

	@Override
	public void twoHole() {
		neutralWire();
		liveWire();
	}

}
