package com.devil.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TwoThreadLock2 {

    private static Lock lock = new ReentrantLock();
    private static Condition ac = lock.newCondition();
    private static Condition bc = lock.newCondition();

    private static boolean flag = false;

    public static void main(String[] args) {
        Thread a = new Thread() {
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        System.out.println("Thread1");
                        bc.signal();
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
                        bc.await();
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
