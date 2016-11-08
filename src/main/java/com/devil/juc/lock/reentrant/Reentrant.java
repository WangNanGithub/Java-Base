package com.devil.juc.lock.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 */
public class Reentrant {
    private static Lock lock = new ReentrantLock();

    private static Runnable createTask() {
        return new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        if (lock.tryLock(500, TimeUnit.MILLISECONDS)) {// 果锁在给定等待时间内没有被另一个线程保持，且当前线程未被中断，则获取该锁。
                            // if (lock.tryLock())//如果该锁没有被另一个线程保持，并且立即返回 true 值，则将锁的保持计数设置为 1。
                            // lock.lock();//如果该锁没有被另一个线程保持，则获取该锁并立即返回，将锁的保持计数设置为 1。
                            // lock.lockInterruptibly();//如果当前线程未被中断，则获取锁。
                            try {
                                System.out.println("locked " + Thread.currentThread().getName());
                                Thread.sleep(1000);
                            } finally {
                                lock.unlock();
                                System.err.println("unlock " + Thread.currentThread().getName());
                            }
                            break;
                        } else {
                            System.out.println("unable to lock " + Thread.currentThread().getName());
                        }
                    } catch (Exception e) {
                        System.out.println(Thread.currentThread().getName() + " is Interrunpted");
                    }
                }
            }
        };
    }

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(createTask(), "One");
        Thread two = new Thread(createTask(), "Two");
        one.start();
        two.start();
        Thread.sleep(600);
        two.interrupt();
    }

}
