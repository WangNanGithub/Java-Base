package com.devil.designmodel.meditor;

/**
 * 抽象中介者
 */
public abstract class Mediator {
    /**
     * 同事对象有改变时，通知中介者的方法
     * 在同事改变时，通过中介者，通知其他同事对象
     */
    public abstract void changed(Colleague c);
}
