package com.devil.effective.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

/**
 * 
 *
 * @author yuansheng
 * @version 1.0.0
 */
public class TestT {
	@Test
	public void test1() {
		ArrayTest<Stu> stu = new ArrayTest<Stu>();
		Stu s1 = new Stu();
		s1.setId(1);
		Stu s2 = new Stu();
		s2.setId(2);
		stu.objs[0] = s1;
		stu.objs[1] = s2;
		stu.es[0] = (Stu) s1;
		stu.es[1] = (Stu) s2;
		Object object = new Stu();

		System.out.println(((Stu) stu.objs[0]).getId());
		System.out.println(((Stu) stu.es[1]).getId());
	}

	@Test
	public void test2() {
		Stu s1 = new Stu();
		s1.setId(1);
		Stu s2 = new Stu();
		s2.setId(2);
		Object[] a = new Stu[] { new Stu(), new Stu() };
		Stu[] array = (Stu[]) a;

		Object[] b = new Object[] { s1, s2, "123" };
		for (Object object : b) {
			System.out.println(object);
		}
		System.out.println(b[0] instanceof Object);
		System.out.println(b[0] instanceof Stu);
		Stu tt = (Stu) b[0];
		System.out.println(tt.getId());
		Stu[] bbb = (Stu[]) b;

		for (int i = 0; i < b.length; i++) {
			Stu ssStu = array[i];
			System.out.println(ssStu.getId());
		}

		Object o = new Stu();
		Stu stu = (Stu) o;

		Stu[] c = (Stu[]) new Object[] { new Stu(), new Stu() };
	}

	@Test
	public void test3() {
		Stuc s1 = new Stuc();
		System.out.println(s1 instanceof Stuc);
		System.out.println(s1 instanceof Stu);
		// Stuc stuc = (Stuc) new Stu();

		Stu s = new Stu();
		Object obj = s;
		Stu ss = (Stu) obj;

		String[] strs = (String[]) new Object[] { "123", "222" };
		for (String string : strs) {
			System.out.println(string);
		}
	}

	@Test
	public void testNotObj() {
		// 如果数组为父类，那么它可以存放父类类型，或者任意类型的子类，如new StuB()，
		// 这样，系统如何将StuB放入Stuc？
		Stuc[] c = (Stuc[]) new Stu[] { new Stuc(), new Stuc() };
	}

	@Test
	public void testNotObj2() {
		// 反过来，如果子类数组转成父类的，后面只能存放Stuc类型的或者它的子类，也就都是Stu的子类，类型转换没有问题
		// 结合toArray方法
		Stu[] c = (Stu[]) new Stuc[] { new Stuc(), new Stucc() };
	}

	@Test
	public void testList() {
		List<Stu> list = new ArrayList<>();
		list.add(new Stu());
		list.toArray(new Stu[6]);
		Object[] objs = list.toArray();// 报错
		Stu[] stus = (Stu[]) objs;
	}

	@Test
	public void testFunNewHashMap() {
		// 老办法创建map，这样每次new的时候都需要制定类型
		HashMap<String, Stu> oldmap = new HashMap<String, Stu>();

		// 通过泛型静态工厂方法来创建,十分简洁
		HashMap<String, Stu> map = FunctionI.newHashMap();
	}

	@Test
	public void testExtendsE() {
		FunctionI<Stu> fun = new FunctionI<Stu>();
		// 如果list中的类型是继承fun的则可以运行
		List<Stuc> list = new ArrayList<Stuc>();
		list.add(new Stuc());
		// fun.onlyE(list); // 编译不通过
		fun.extendsE(list);
		// fun.superE(list);// 编译不通过
		// 如果不是继承的
		List<Stu> list2 = new ArrayList<Stu>();
		list2.add(new Stu());
		fun.onlyE(list2);
		fun.extendsE(list2);
		fun.superE(list2);
	}

	@Test
	public void testunion() {
		List<Integer> list1 = new ArrayList<Integer>();
	}

}
