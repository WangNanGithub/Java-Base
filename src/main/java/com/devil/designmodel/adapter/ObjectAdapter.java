package com.devil.designmodel.adapter;

public class ObjectAdapter implements MainlandPlug {

	private HongkongPlug hkp;

	public ObjectAdapter(HongkongPlug hkp) {
		this.hkp = hkp;
	}

	@Override
	public void twoHundredTwentyV() {
		hkp.voltage = 220;
		hkp.rs += 2;
		hkp.twoHundredV();

	}

	@Override
	public void twoHole() {
		hkp.neutralWire();
		hkp.liveWire();
	}

}
