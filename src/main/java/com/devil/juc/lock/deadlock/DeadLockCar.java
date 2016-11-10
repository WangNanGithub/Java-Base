package com.devil.juc.lock.deadlock;

import java.util.concurrent.locks.ReentrantLock;
/**
 * ↓←←
 * ↓    ↑
 * →→↑
 * 
 * 两个箭头表示一辆车，如果他们都朝现在的方向前进，前面都有车堵着，但是车都不让位，这就造成了死锁
 */
public class DeadLockCar extends Thread {
    protected Object myDirect;
    static ReentrantLock south = new ReentrantLock();
    static ReentrantLock north = new ReentrantLock();
    static ReentrantLock west = new ReentrantLock();
    static ReentrantLock east = new ReentrantLock();

    public DeadLockCar(Object obj) {
        this.myDirect = obj;
        if (myDirect == south) {
            this.setName("south");
        }
        if (myDirect == north) {
            this.setName("north");
        }
        if (myDirect == west) {
            this.setName("west");
        }
        if (myDirect == east) {
            this.setName("east");
        }
    }

    @Override
    public void run() {
        if (myDirect == south) {
            try {
                west.lockInterruptibly(); // 占据向西的路 lockInterruptibly如果当前线程未被中断，则获取锁
                Thread.sleep(500);
                south.lockInterruptibly(); // 等待向南的路
                System.out.println("car to south has passed");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (west.isHeldByCurrentThread()) // isHeldByCurrentThread查询当前线程是否保持此锁
                    west.unlock();
                if (south.isHeldByCurrentThread())
                    south.unlock();

            }
        }
        if (myDirect == north) {
            try {
                east.lockInterruptibly(); // 占据向西的路 lockInterruptibly如果当前线程未被中断，则获取锁
                Thread.sleep(500);
                north.lockInterruptibly(); // 等待向南的路
                System.out.println("car to north has passed");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (east.isHeldByCurrentThread()) // isHeldByCurrentThread查询当前线程是否保持此锁
                    east.unlock();
                if (north.isHeldByCurrentThread())
                    north.unlock();

            }
        }
        if (myDirect == west) {
            try {
                north.lockInterruptibly(); // 占据向西的路 lockInterruptibly如果当前线程未被中断，则获取锁
                Thread.sleep(500);
                west.lockInterruptibly(); // 等待向南的路
                System.out.println("car to west has passed");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (west.isHeldByCurrentThread()) // isHeldByCurrentThread查询当前线程是否保持此锁
                    west.unlock();
                if (north.isHeldByCurrentThread())
                    north.unlock();

            }
        }
        if (myDirect == east) {
            try {
                south.lockInterruptibly(); // 占据向西的路 lockInterruptibly如果当前线程未被中断，则获取锁
                Thread.sleep(500);
                east.lockInterruptibly(); // 等待向南的路
                System.out.println("car to east has passed");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (east.isHeldByCurrentThread()) // isHeldByCurrentThread查询当前线程是否保持此锁
                    east.unlock();
                if (south.isHeldByCurrentThread())
                    south.unlock();

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLockCar car2south = new DeadLockCar(south);
        DeadLockCar car2north = new DeadLockCar(north);
        DeadLockCar car2east = new DeadLockCar(east);
        DeadLockCar car2west = new DeadLockCar(west);
        car2east.start();
        car2north.start();
        car2west.start();
        car2south.start();

        Thread.sleep(20000); // 让小车死锁一段时间
        car2north.interrupt(); // interrupt中断线程，强行剥夺小车资源，解除死锁
    }

}
