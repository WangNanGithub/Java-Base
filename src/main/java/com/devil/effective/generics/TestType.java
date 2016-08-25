package com.devil.effective.generics;

import org.junit.Test;

public class TestType {

	@Test
	public void testLowToHeight() {
		byte b = 0;
		int i = b;
		long l = b;
		float f = b;
		double d = b;

		// byte a=d; // double比byte高级，不能通过

		char c = 'c';
		int j = c;
		System.out.println("output:" + j);

		// byte a =c; // char与byte同级，不能通过
	}

	@Test
	public void testObjLowToHeigh() {
		Object obj = new String();
		System.out.println(obj.getClass());
		String s = (String) obj; // 编译和运行都正常
		Object obj2 = new Object();
		System.out.println(obj2.getClass());
		// String ss = (String) obj2; // 编译通过，运行报类型转换异常
	}

	@Test
	public void testArray() {
		// Stu[] c = (Stu[]) new Object[] { new Stu(), new Stu(),"1232131" };
		// Stu[] c = (Stu[]) new Object[] { new Stu(), new Stu() };
		Object[] objs = new Object[] { new Stu(), new Stu() };
		System.out.println(objs.getClass());

		Stu[] c = new Stu[objs.length];
		for (int i = 0, j = objs.length; i < j; i++) {
			c[i] = (Stu) objs[i];
		}
	}

}
