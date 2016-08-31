package com.devil.designmodel.singleton.hunger;

/**
 * 内部类式中，实现了延迟加载，只有我们调用了getInstance(),才会加载StaticClass创建唯一的实例INSTANCE到内存中.
 * 
 * 并且也解决了懒汉式中多线程的问题.
 */
public class SingletonStaticClass {

    private static class StaticClass {
        private static final SingletonStaticClass INSTANCE = new SingletonStaticClass();
    }

    private SingletonStaticClass() {}

    public static SingletonStaticClass getInstance() {
        return StaticClass.INSTANCE;
    }
}
