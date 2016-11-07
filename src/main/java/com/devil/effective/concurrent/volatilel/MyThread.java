package com.devil.effective.concurrent.volatilel;
/**
 * 用java -client class 效果不明显
 * 用java -server class jvm会对代码做一些优化，当一执行stop就改变
 *
 */
public class MyThread extends Thread {
    private volatile boolean stop = false;

    public void stopMe() {
        stop = true;
    }

    @Override
    public void run() {
        int i = 0;
        while (!stop) {
            i++;
            System.out.println(i);
        }
        System.out.println("Stop Thread");
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread();
        mt.start();
        Thread.sleep(1000);
        mt.stopMe();
        Thread.sleep(1000);
    }
}
