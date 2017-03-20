package com.devil.pro.base;

import java.math.BigInteger;

// integer溢出上限，可以使用biginteger
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
