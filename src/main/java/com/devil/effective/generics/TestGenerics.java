package com.devil.effective.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

import org.junit.Test;

public class TestGenerics {

	@Test
	public void testList() {
		List<Stu> list = new ArrayList<>();

		Object[] objs = list.toArray();
		Stu[] stus = (Stu[]) objs;// 报错

		Stu[] objsa = list.toArray(new Stu[6]);
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
		List<Stu> liStus = new ArrayList<>();
		FunctionI.superEstatic(liStus); // 编译通过
		FunctionI.superEstatic(new ArrayList<Stuc>());
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
		List<Double> list2 = new ArrayList<Double>();
		// List<Number> list3 = FunctionI.unionUndo(list1, list2); // 无法编译通过,因为泛型E无法确定

		List<Number> list4 = FunctionI.<Number> unionExt(list1, list2); // 在方法前指定了E的类型，由于list1和2中存放的类型都是Number的子类
	}

	@Test
	public void testMaxOne() {
		// FunctionI.maxOne(new ArrayList<Number>()); // Number未实现Comparable<E>接口，报错
		// <E extends Comparable<E>> E maxOne(List<E> list)
		// Integer extends Number implements Comparable<Integer> 所以E必须是实现Comparable<E>接口
		FunctionI.maxOne(new ArrayList<Integer>()); // Integer实现Comparable接口，通过
	}

	@Test
	public void testMaxTwo() {
		List<ScheduledFuture<Integer>> sch = null;
		// FunctionI.maxOne(sch); // 普通方法不能通过编译,ScheduledFuture没有实现comparable接口，ps:但是实现Delayed接口，而Delayed接口实现Comparable
		// <E extends Comparable<? super E>> E maxTwo(List<? extends E> list)
		// ScheduledFuture<V> extends Delayed
		// Delayed extends Comparable<Delayed>
		FunctionI.maxTwo(sch); // 编译通过
		// 拆分，先看E extends Comparable<? super E> 表示E实现Comparable，而且传入的类型？必须为E的
	}

	@Test
	public void testDemo() {
		// GregorianCalendar extends Calendar
		// Calendar implements Comparable<Calendar>
		// 这里相当于<GregorianCalendar extends
		// Comparable<GregorianCalendar>>，但是GregorianCalendar继承了Comparable<Calendar>而不是Comparable<Calendar>
		// Demo1<GregorianCalendar> p = null;
		// <GregorianCalendar extends Comparable<Calendar>> T 表示传入的值，？通配符 super
		// 决定Comparable的类型为Calendar
		Demo2<GregorianCalendar> p2 = null;
		
		Collections.max(new ArrayList<GregorianCalendar>());
	}

}

class Demo1<T extends Comparable<T>> {
}

class Demo2<T extends Comparable<? super T>> {
}
