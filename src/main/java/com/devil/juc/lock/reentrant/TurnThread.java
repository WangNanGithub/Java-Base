package com.devil.juc.lock.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock实现交替线程和synchronize十分相似，可以通过sleep来实现让另一线程获取锁(这种方式和正真的意义不符)
 */
public class TurnThread {
    private static Lock lock = new ReentrantLock();
    private static boolean flag = false;

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (lock.tryLock()) {
                        if (flag) {
                            System.out.println("Thread1");
                            flag = false;
                        }
                        lock.unlock();
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (lock.tryLock()) {
                        if (!flag) {
                            System.out.println("Thread2");
                            flag = true;
                        }
                        lock.unlock();
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}
