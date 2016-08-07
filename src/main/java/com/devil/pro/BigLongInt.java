package com.devil.pro;

import java.math.BigInteger;

public class BigLongInt {
	public static void main(String[] args) {
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		int sum = a + b;
		System.out.println("a=" + a + ",b=" + b + ",sum=" + sum);

		String bs = "11111111111";
		BigInteger big = new BigInteger(bs);
		System.out.println(bs);
		System.out.println(big);
	}
}
