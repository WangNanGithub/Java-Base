package com.devil.test;

/**
 * 
 * @author ys
 * @date 2016年4月28日 上午11:33:36
 * @version 1.0.0
 *
 *          对异常的测试（如果是try/cath后的代码还是执行的，但是try中错误代码之后的代码不会执行）
 */
public class TestExctption {
	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test() throws Exception {
		// err();
		// try {
		// thro();
		// System.out.println(2222);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		thro();
		System.out.println(1111);
	}

	public static void err() {
		try {
			System.out.println(1 / 0);
			System.out.println(2222);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static void thro() throws Exception {
		System.out.println(1 / 0);
	}
}
