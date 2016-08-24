package com.devil.juc;

/**
 * 模仿两个线程交替执行
 * 
 * @author Devil
 * @date 2016年8月21日 下午11:12:30
 * @version $Id$
 *
 */
public class TwoThreadSync {

	private static Object lock = new Object();
	private static boolean flag = false;

	public static void main(String[] args) {

		Thread a = new Thread() {
			public void run() {
				while (true) {
					synchronized (lock) {
						if (flag) {
						    System.out.println("Thread1");
							flag = false;
							lock.notify();
							try {
								lock.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}

				}
			}
		};

		Thread b = new Thread() {
			public void run() {
				while (true) {
					synchronized (lock) {
						if (!flag) {
						    System.out.println("Thread2");
							flag = true;
							try {
								lock.notify();
								lock.wait();
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
						}
					}

				}
			}
		};

		a.start();
		b.start();
	}
}
