package com.devil.test;

import java.text.DecimalFormat;

public class TestDouble {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("0.00");
		Double a = new Double(0.03);
		Double b = new Double(0.01);
		System.out.println(a - b);
		System.out.println(df.format(a-b));
		
		Double ac=1.11;
        Double bc=1.00;
        System.out.println(ac+bc);
        
        System.out.println(101/100.0);
        String c="100";
        System.out.println(Double.valueOf(c)/100);
        System.out.println(0.03*100);
        System.out.println(101/100);
	}
}
