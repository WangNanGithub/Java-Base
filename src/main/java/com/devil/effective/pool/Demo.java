package com.devil.effective.pool;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;

public class Demo {
	static PooledObjectFactory<Object> factory = new PoolFactoryDemo();
	static ObjectPool<Object> pool = new GenericObjectPool<Object>(factory);
	private static AtomicInteger endcount = new AtomicInteger(0);

	public static class PoolThread extends Thread {
		@Override
		public void run() {
			Object obj = null;
			try {
				for (int i = 0; i < 100; i++) {
					System.out.println("== " + i + "==");
					obj = pool.borrowObject();// 从池中获取对象
					System.out.println(obj + " is get");
					pool.returnObject(obj);// 使用完，返回对象到池中
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				endcount.getAndIncrement();
			}
		}
	}

	public static void main(String[] args) {
		new PoolThread().start();
		new PoolThread().start();
		new PoolThread().start();
		while (true) {
			if (endcount.get() == 3) { // 等待三个线程全部结束
				pool.close(); // 关闭时调用destroyObject方法
				break;
			}
		}
	}

}
