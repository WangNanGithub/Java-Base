package com.devil.juc.concurrent.sync;

/**
 * 模仿两个线程交替执行
 */
public class TrunThread {

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
