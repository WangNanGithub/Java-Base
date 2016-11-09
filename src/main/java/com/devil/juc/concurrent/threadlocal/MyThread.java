package com.devil.juc.concurrent.threadlocal;

import java.util.Date;

/**
 * 
 */
public class MyThread implements Runnable {

    public static final ThreadLocal<Date> localvar = new ThreadLocal<Date>();
    private long time;

    public MyThread(long time) {
        this.time = time;
    }

    @Override
    public void run() {
        Date date = new Date(time);
        for (int i = 0; i < 50000; i++) {
            localvar.set(date); // 设置一个线程的local值，不会影响到其他线程
        }
        if (localvar.get().getTime() != time) {
            System.out.println("id=" + time + " localvar=" + localvar.get().getTime());
        }
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Thread t1 = new Thread(new MyThread(time));
        t1.start();
        Thread t2 = new Thread(new MyThread(time));
        t2.start();
        Thread t3 = new Thread(new MyThread(time));
        t3.start();
    }

}
