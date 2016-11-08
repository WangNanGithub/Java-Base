package com.devil.juc.lock.readwrite;

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
			if (lock.tryLock()) {
				i++;
				System.out.println(i + "读数据" + (System.currentTimeMillis() - start) + "ms");
				lock.unlock();
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void reenWrite(long start) {
		try {
			if (lock.tryLock()) {
				i++;
				System.out.println(i + "写数据" + (System.currentTimeMillis() - start) + "ms");
				lock.unlock();
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		long start = System.currentTimeMillis();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				while (true) {
					reenRead(start);
				}
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				while (true) {
					reenRead(start);
				}
			}
		};
		Thread t3 = new Thread() {
			@Override
			public void run() {
				while (true) {
					reenWrite(start);
				}
			}
		};
		t1.start();
		t2.start();
		t3.start();
		System.out.println("all start");
	}

	public void read() {
		try {
			readLock.lock();
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			readLock.unlock();
		}
	}

	public void write() {
		try {
			writeLock.lock();
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			writeLock.unlock();
		}
	}

}
