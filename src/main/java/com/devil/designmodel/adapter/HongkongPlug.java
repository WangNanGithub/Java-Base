package com.devil.designmodel.adapter;

// 原接口--三孔插头 输入电压200v
public class HongkongPlug {

	int voltage = 200;
	int rs = 20;
	// 200v的输出方法
	public void twoHundredV() {
		System.out.println(voltage / rs);
	}
	// 三孔插头
	public void threeHole() {
		neutralWire();
		liveWire();
		groundWire();
	}

	public void neutralWire() {
		System.out.println("火线");
	};

	public void liveWire() {
		System.out.println("零线");
	};

	public void groundWire() {
		System.out.println("地线");
	};

}
