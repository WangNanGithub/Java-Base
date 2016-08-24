package com.devil.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 *
 * @author yuansheng
 * @version 1.0.0
 */
public class TwoThreadLock {
    public static void main(String[] args) {
        PrintThread pt = new PrintThread();
        LockThread t1 = new LockThread(pt);
        LockThread t2 = new LockThread(pt);

        t1.start();
        t2.start();
    }
}

class PrintThread {
    private Lock lock;

    public PrintThread() {
        lock = new ReentrantLock();
    }

    public void print() {
        lock.lock();
        lock.notifyAll();
        System.out.println(Thread.currentThread().getName());
        try {
            lock.wait();
            lock.unlock();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

class LockThread extends Thread {

    private PrintThread pt;

    public LockThread(PrintThread pt) {
        this.pt = pt;
    }

    @Override
    public void run() {
        while (true) {
            pt.print();
        }
    }
}
