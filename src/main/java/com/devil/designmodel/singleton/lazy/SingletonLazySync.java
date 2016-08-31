package com.devil.designmodel.singleton.lazy;

/**
 * 使用同步方法synchronized,能够在多线程中很好的工作，遗憾的是，效率很低
 *
 */
public class SingletonLazySync {
    private static SingletonLazySync uniqueInstance;

    private SingletonLazySync() {}

    public static synchronized SingletonLazySync getInstance() {
        // synchronized防止在多线程的情况下创建时会产生多个对象(但是synchronized会降低性能,同步一个方法能使程序效率下降100倍)
        // 下面是延迟实例化的方法
        if (uniqueInstance == null)
            uniqueInstance = new SingletonLazySync();

        return uniqueInstance;
    }

}
