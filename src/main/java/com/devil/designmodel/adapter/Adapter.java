package com.devil.designmodel.adapter;

/**
 * 适配器是实现一个特殊需求的类，以满足客户的需求。
 * 如下面的适配器用Chicken来替代Duck
 *
 * @author yuansheng
 * @version 1.0.0
 */
public class Adapter implements Duck {
    private Chicken chicken;

    public Adapter(Chicken chicken) {
        this.chicken = chicken;
    }

    // 叫声改变不了
    public void call() {
        chicken.call();
    }

    public void fly() {
        // 鸡要不停的跳，看起来像飞起来
        for (int i = 0; i < 10; i++) {
            chicken.jump();
        }
    }
}
