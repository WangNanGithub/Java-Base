package com.devil.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日HH时");
		System.out.println(sdf.format(new Date()));
	}
}
