package com.devil.network.thread;

/**
 * 
 * @author ys
 * @date 2016年5月13日 下午5:57:57
 * @version 1.0.0
 *
 *          使用锁，synchronized同步代码 两个run方法都需要锁对象，才能继续执行，在一次执行后放开锁
 */
public class SynchronizeCode2 {

	public static void main(String[] args) {
		/************ 创建锁对象 ************/
		final Object lock = new Object();
		/************ 开启线程一 ************/
		new Thread() {
			public void run() {
				while (true) {
					synchronized (lock) {
						System.out.print("同步");
						System.out.println("代码");
					}
				}
			};
		}.start();
		/************ 开启线程二 ************/
		new Thread() {
			public void run() {
				while (true) {
					synchronized (lock) {
						System.out.print("Synchronize");
						System.out.println("Code");
					}
				}
			};
		}.start();
	}
}
