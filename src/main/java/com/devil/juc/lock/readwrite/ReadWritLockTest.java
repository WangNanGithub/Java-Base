package com.devil.juc.lock.readwrite;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.junit.Test;

/**
 * 通过比较ReentrantLock和ReadWritLock的效率说明
 */
public class ReadWritLockTest {
    private volatile int i = 0;
    private Lock lock = new ReentrantLock();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    public void reenRead(long start) {
        try {
            System.out.println(i);
            lock.lock(); // 一直尝试获取锁，阻塞
            Thread.sleep(1);
            i++;
            System.out.println(i + "读数据" + (System.currentTimeMillis() - start) + "ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void reenWrite(long start) {
        try {
            System.out.println(i);
            lock.lock();
            Thread.sleep(1);
            i++;
            System.out.println(i + "写数据" + (System.currentTimeMillis() - start) + "ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Test
    public void testReen() {
        long start = System.currentTimeMillis();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (i < 10000) {
                    reenRead(start);
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (i < 10000) {
                    reenRead(start);
                }
            }
        };
        Thread t3 = new Thread() {
            @Override
            public void run() {
                while (i < 10000) {
                    reenWrite(start);
                }
            }
        };
        t1.start();
        t2.start();
        t3.start();
        System.out.println("all start");
        try {
            // 单元测试，Junit 在方法全部执行结束后就结束
            // 这里需要将主线程阻塞，相当于死循环（不用死循环是因为太消耗性能）
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**
         * 9999
         * 
         * 10000读数据10004ms
         * 
         * 10001写数据10005ms
         * 
         * 10002读数据10006ms
         * 
         * 虽然while限制到10000，但是由于在9999的时候，三个线程都已经在lock.lock()，阻塞，当有锁释放，则就马上执行，之后会发现不满足
         */
    }

    public void read(long start) {
        try {
            System.out.println(i);
            readLock.lock();
            Thread.sleep(1);
            i++;
            System.out.println(i + "读数据" + (System.currentTimeMillis() - start) + "ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public void write(long start) {
        try {
            System.out.println(i);
            writeLock.lock();
            Thread.sleep(1);
            i++;
            System.out.println(i + "写数据" + (System.currentTimeMillis() - start) + "ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    @Test
    public void testReadWrite() {
        long start = System.currentTimeMillis();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (i < 10000) {
                    read(start);
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (i < 10000) {
                    read(start);
                }
            }
        };
        Thread t3 = new Thread() {
            @Override
            public void run() {
                while (i < 10000) {
                    write(start);
                }
            }
        };
        t1.start();
        t2.start();
        t3.start();
        System.out.println("all start");
        try {
            // 单元测试，Junit 在方法全部执行结束后就结束
            // 这里需要将主线程阻塞，相当于死循环（不用死循环是因为太消耗性能）
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 9999
        // 10000写数据9546ms 可以看出，比上面节省部分时间，时间节省随读线程的增多而增加
        // 10001读数据9547ms
        // 10002读数据9547ms
    }
}
