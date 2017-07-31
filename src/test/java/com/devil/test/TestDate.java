package com.devil.test;

import com.devil.utils.SizeOfObject;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日HH时");
		System.out.println(sdf.format(new Date()));
	}


	@Test
	public void test(){
		System.out.println(SizeOfObject.sizeOf(new int[Integer.MAX_VALUE / 1024]));
	}
}
