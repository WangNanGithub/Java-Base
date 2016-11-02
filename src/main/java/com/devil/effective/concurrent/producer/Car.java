package com.devil.effective.concurrent.producer;

/**
 * 任务：生产者向缓存区提交的数据
 */
public final class Car {
    private final int data;

    public Car(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

}
