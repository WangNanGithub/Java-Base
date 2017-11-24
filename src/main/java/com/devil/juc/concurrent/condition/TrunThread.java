package com.devil.juc.concurrent.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock与Condition实现交替线程
 */
public class TrunThread {

    private static Lock lock = new ReentrantLock();
    private static Condition ac = lock.newCondition();

    public static void main(String[] args) {
        Thread a = new Thread() {
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        System.out.println("Thread1");
                        ac.signal();
                        ac.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };

        Thread b = new Thread() {
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        System.out.println("Thread2");
                        ac.signal();
                        ac.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };

        a.start();
        b.start();
    }
}
