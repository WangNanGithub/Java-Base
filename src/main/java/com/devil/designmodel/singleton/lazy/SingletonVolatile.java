package com.devil.designmodel.singleton.lazy;

public class SingletonVolatile {
	// volatile保证在多线程的时候，每个线程能正确的处理这个单例
	private volatile static SingletonVolatile uniqueInstance;

	private SingletonVolatile() {}

	public static SingletonVolatile getInstance() {
		// 使用双重检验加锁，在getInstance方法中减少同步
		if (uniqueInstance == null)
			synchronized (SingletonVolatile.class) {
				if (uniqueInstance == null)
					uniqueInstance = new SingletonVolatile();
			}
		return uniqueInstance;
	}
}
