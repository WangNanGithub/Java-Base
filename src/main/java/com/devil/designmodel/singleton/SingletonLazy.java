package com.devil.designmodel.singleton;

public class SingletonLazy {
	private static SingletonLazy uniqueInstance;

	private SingletonLazy() {

	}

	public static synchronized SingletonLazy getInstance() {
		// synchronized防止在多线程的情况下创建时会产生多个对象(但是synchronized会降低性能,同步一个方法能使程序效率下降100倍)
		// 下面是延迟实例化的方法
		if (uniqueInstance == null)
			uniqueInstance = new SingletonLazy();

		return uniqueInstance;
	}
}
