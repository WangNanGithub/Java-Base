package com.devil.juc.lock.Semaphore;

import java.util.concurrent.Semaphore;

/**
 * 使用JDK文档中的例子
 * 
 * pool中相当于仓库，存放着部分资源
 * 
 * Semaphore存放信号量，表示最大访问仓库的线程个数
 */
public class SemaphorePool {
    public static void main(String[] args) {
        Pool pool = new Pool();
        String[] strs = new String[] { "???", "&(*&^", "~!@@#", "%#%#%", "**^%E##" };
        pool.setItems(strs);
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Object obj = pool.getItem();// 获取资源
                        System.out.println("t1获取到:" + obj + " 可用信号:" + pool.availablePermits());// 使用资源
                        pool.putItem(obj);// 放回资源
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Object obj = pool.getItem();// 获取资源
                        System.out.println("t2获取到:" + obj + " 可用信号:" + pool.availablePermits());// 使用资源
                        pool.putItem(obj);// 放回资源
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t3 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Object obj = pool.getItem();// 获取资源
                        System.out.println("t3获取到:" + obj + " 可用信号:" + pool.availablePermits());// 使用资源
                        pool.putItem(obj);// 放回资源
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t4 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Object obj = pool.getItem();// 获取资源
                        System.out.println("t4获取到:" + obj + " 可用信号:" + pool.availablePermits());// 使用资源
                        pool.putItem(obj);// 放回资源
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Pool {
    private static final int MAX_AVAILABLE = 2; // 设置最大有2个访问权
    private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);// 设置许可数和公平机制

    public Object getItem() throws InterruptedException {
        available.acquire(); // 申请一个许可
        return getNextAvailableItem();
    }

    public void putItem(Object x) {// 将给定项放回池内
        if (markAsUnused(x))
            available.release();
    }

    protected Object[] items = null; // 存放对象池中的复用对象
    protected boolean[] used = new boolean[MAX_AVAILABLE];// 用于标识池中的项是否正在被使用

    protected synchronized Object getNextAvailableItem() {// 获取可用项
        for (int i = 0; i < MAX_AVAILABLE; ++i) {
            if (!used[i]) {
                used[i] = true;
                return items[i];
            }
        }
        return null;
    }

    protected synchronized boolean markAsUnused(Object item) {
        for (int i = 0; i < MAX_AVAILABLE; ++i) {
            if (item == items[i]) {
                if (used[i]) {
                    used[i] = false;
                    return true;
                } else
                    return false;
            }
        }
        return false;
    }

    protected synchronized int availablePermits() {
        return available.availablePermits();
    }

    public void setItems(Object[] items) {
        this.items = items;
    }
}
