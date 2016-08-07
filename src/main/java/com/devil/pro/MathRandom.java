package com.devil.pro;

public class MathRandom {
	public static void main(String[] args) {
		// round表示四舍五入
		System.out.println(Math.round(11.5) + "," + Math.round(-11.5) + "," + Math.round(11.4));

		// ceil的英文意义是天花板，该方法就表示向上取整
		System.out.println(Math.ceil(11.5) + "," + Math.ceil(-11.5) + "," + Math.ceil(11.4));

		// floor的英文意义是地板，该方法就表示向下取整
		System.out.println(Math.floor(11.5) + "," + Math.floor(-11.5) + "," + Math.floor(11.4));
	}
}
