package com.devil.designmodel.singleton.lazy;

public class SingletonLazyNoSync {
	private static SingletonLazyNoSync uniqueInstance;

	private SingletonLazyNoSync() {

	}

	// 静态工厂方法
	public static SingletonLazyNoSync getInstance() {
		// 下面是延迟实例化的方法
		if (uniqueInstance == null)
			uniqueInstance = new SingletonLazyNoSync();

		return uniqueInstance;
	}
}
