package com.devil.juc;

public class TestSwitch {
	public static void main(String[] args) {
		String ty="payTimerDef";
		switch (ty) {
		case "payTimerDef":
			System.out.println("true");
			break;

		default:
			System.out.println("false");
			break;
		}
	}

}
