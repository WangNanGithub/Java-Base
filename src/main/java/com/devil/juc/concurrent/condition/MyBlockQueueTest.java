package com.devil.juc.concurrent.condition;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * BlockingQueue控制队列满的时候让生产者等待，在队列空的时候让消费者等待。它使用的就是Conditon，可以查看ArrayBlockingQueue源码，put，insert，
 * take等方法
 * 
 *
 */
public class MyBlockQueueTest {
    private static MyBlockQueue bb = new MyBlockQueue();

    public static void main(String[] args) {
        // 启动10个“写线程”，向MyBlockQueue中不断的写数据(写入0-9)；
        // 启动10个“读线程”，从MyBlockQueue中不断的读数据。
        for (int i = 0; i < 10; i++) {
            new PutThread("p" + i, i).start();
            new TakeThread("t" + i).start();
        }
    }

    static class PutThread extends Thread {
        private int num;

        public PutThread(String name, int num) {
            super(name);
            this.num = num;
        }

        public void run() {
            try {
                Thread.sleep(1); // 线程休眠1ms
                bb.put(num); // 向MyBlockQueue中写入数据
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class TakeThread extends Thread {
        public TakeThread(String name) {
            super(name);
        }

        public void run() {
            try {
                Thread.sleep(10); // 线程休眠1ms
                // Integer num = (Integer) bb.take(); // 从MyBlockQueue中取出数据
                bb.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyBlockQueue {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[5];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock(); // 获取锁
        try {
            // 如果“缓冲已满”，则等待；直到“缓冲”不是满的，才将x添加到缓冲中。
            while (count == items.length)
                notFull.await();
            // 将x添加到缓冲中
            items[putptr] = x;
            // 将“put统计数putptr+1”；如果“缓冲已满”，则设putptr为0。
            if (++putptr == items.length)
                putptr = 0;
            // 将“缓冲”数量+1
            ++count;
            // 唤醒take线程，因为take线程通过notEmpty.await()等待
            notEmpty.signal();

            // 打印写入的数据
            System.out.println(Thread.currentThread().getName() + " put  " + (Integer) x);
        } finally {
            lock.unlock(); // 释放锁
        }
    }

    public Object take() throws InterruptedException {
        lock.lock(); // 获取锁
        try {
            // 如果“缓冲为空”，则等待；直到“缓冲”不为空，才将x从缓冲中取出。
            while (count == 0)
                notEmpty.await();
            // 将x从缓冲中取出
            Object x = items[takeptr];
            // 将“take统计数takeptr+1”；如果“缓冲为空”，则设takeptr为0。
            if (++takeptr == items.length)
                takeptr = 0;
            // 将“缓冲”数量-1
            --count;
            // 唤醒put线程，因为put线程通过notFull.await()等待
            notFull.signal();

            // 打印取出的数据
            System.out.println(Thread.currentThread().getName() + " take " + (Integer) x);
            return x;
        } finally {
            lock.unlock(); // 释放锁
        }
    }
}