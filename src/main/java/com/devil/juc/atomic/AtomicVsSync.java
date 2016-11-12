package com.devil.juc.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

/**
 * 测试使用原子操作（无锁）和同步锁的性能比较
 * 
 * sync:Spend:26ms v=1000000
 * 
 * atomic:Spend:10ms v=1000000
 */
public class AtomicVsSync {
    private static final int MAX_THREADS = 3;// 线程数
    private static final int TASK_COUNT = 1;// 任务数
    private static final int TARGET_COUNT = 1000000;// 目标总数
    private AtomicInteger account = new AtomicInteger(0);// 无锁的原子操作
    private int count = 0;

    protected synchronized int inc() {// 有锁的加法
        return ++count;
    }

    protected synchronized int getCount() {// 有锁的操作
        return count;
    }

    class SyncThread implements Runnable {
        protected long startTime;
        AtomicVsSync out;

        public SyncThread(AtomicVsSync out, long startTime) {
            this.out = out;
            this.startTime = startTime;
        }

        @Override
        public void run() {
            int v = out.getCount(); // 进行有锁的加法
            while (v < TARGET_COUNT) {
                v = out.inc();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Spend:" + (endTime - startTime) + "ms v=" + v);
        }
    }

    @Test
    public void testSync() {
        ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);
        long startTime = System.currentTimeMillis();
        SyncThread thread = new SyncThread(this, startTime);
        for (int i = 0; i < TASK_COUNT; i++) { // 同时3个线程操作
            executor.submit(thread);
        }
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class AtomicThread implements Runnable {
        protected long startTime;

        public AtomicThread(long startTime) {
            this.startTime = startTime;
        }

        @Override
        public void run() {
            int v = account.incrementAndGet();
            while (v < TARGET_COUNT) {
                v = account.incrementAndGet();// 原子操作
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Spend:" + (endTime - startTime) + "ms v=" + v);
        }
    }

    @Test
    public void testAtomic() {
        ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);
        long startTime = System.currentTimeMillis();
        AtomicThread thread = new AtomicThread(startTime);
        for (int i = 0; i < TASK_COUNT; i++) { // 同时3个线程操作
            executor.submit(thread);
        }
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
