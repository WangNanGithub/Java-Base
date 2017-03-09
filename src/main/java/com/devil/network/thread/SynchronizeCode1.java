package com.devil.network.thread;

/**
 * 
 * @author ys
 * @date 2016年5月13日 下午5:57:57
 * @version 1.0.0
 *
 *          没有使用同步代码块，在一个线程的run方法中，可能没有结束就被另外线程抢占
 */
public class SynchronizeCode1 {

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				while (true) {
					System.out.print("同步");
					System.out.println("代码");
				}
			};
		}.start();
		new Thread() {
			public void run() {
				while (true) {
					System.out.print("Synchronize");
					System.out.println("Code");
				}
			};
		}.start();
	}
}
