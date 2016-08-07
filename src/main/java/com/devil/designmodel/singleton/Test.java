package com.devil.designmodel.singleton;

public class Test {
	public static void main(String[] args) {
		SingletonLazy s1 = SingletonLazy.getInstance();
		System.out.println(s1);
		SingletonLazy s2 = SingletonLazy.getInstance();
		System.out.println(s2);
		//可以看出两者的存储空间是相同的
		
		
	}
}
