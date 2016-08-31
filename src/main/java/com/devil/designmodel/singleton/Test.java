package com.devil.designmodel.singleton;

import com.devil.designmodel.singleton.lazy.SingletonLazy;

public class Test {
	public static void main(String[] args) {
		SingletonLazy s1 = SingletonLazy.getInstance();
		System.out.println(s1);
		SingletonLazy s2 = SingletonLazy.getInstance();
		System.out.println(s2);
		//可以看出两者的地址是相同的
		
		
	}
}
