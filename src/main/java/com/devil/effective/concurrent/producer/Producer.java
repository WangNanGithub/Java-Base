package com.devil.effective.concurrent.producer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 */
public class Producer implements Runnable {
    private volatile boolean isRunning = true;
    private BlockingQueue<Car> queue;// 数据缓冲区
    private static AtomicInteger count = new AtomicInteger(); // 总数，原子操作

    private static final int SLEEPTIME = 1000;

    public Producer(BlockingQueue<Car> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Car car = null;
        Random r = new Random();
        System.out.println("start producer id =" + Thread.currentThread().getId());
        try {
            while (isRunning) {
                Thread.sleep(r.nextInt(SLEEPTIME));
                car = new Car(count.incrementAndGet());// 开始建造数据
                System.out.println(car + " is put into queue");
                if (!queue.offer(car, 2, TimeUnit.SECONDS)) {
                    System.err.println("failed to put data:" + car);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        isRunning = false;
    }

}
