package com.devil.test;

import java.text.DecimalFormat;

public class TestDouble {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("0.00");
		Double a = new Double(0.03);
		Double b = new Double(0.01);
		System.out.println(a - b);
		System.out.println(df.format(a-b));
	}
}
