package com.devil.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日HH时");
		System.out.println(sdf.format(new Date()));
		
		
		Double a=1.11;
		Double b=1.00;
		System.out.println(a+b);
		
		System.out.println(101/100.0);
		String c="100";
		System.out.println(Double.valueOf(c)/100);
		System.out.println(0.03*100);
		System.out.println(101/100);
	}
}
