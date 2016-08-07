package com.devil.designmodel.singleton;

public class SingletonStatic {
	private static SingletonStatic uniqueInstance = new SingletonStatic();

	private SingletonStatic() {

	}

	public static SingletonStatic getInstance() {
		// 这种方式也能防止多线程的时候创建多个对象，因为这样在JVM加载这个类的时候马上创建了一个单例
		return uniqueInstance;
	}
}
