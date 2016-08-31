package com.devil.designmodel.singleton.hunger;

/**
 * 饿汉式提前实例化，但不管我们是不是调用getInstance()都会存在一个实例在内存中
 */
public class SingletonStatic {
    private SingletonStatic() {}

    private static final SingletonStatic single = new SingletonStatic();

    public static SingletonStatic getInstance() {
        return single;
    }
}