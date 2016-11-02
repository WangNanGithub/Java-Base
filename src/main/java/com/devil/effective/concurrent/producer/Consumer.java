package com.devil.effective.concurrent.producer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * 
 */
public class Consumer implements Runnable {
    private BlockingQueue<Car> queue;
    private static final int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<Car> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("start Consumer id=" + Thread.currentThread().getId());
        Random r = new Random();
        try {
            while (true) {
                Car car = queue.take(); // 获取任务
                if (null != car) {
                    int re = car.getData() * car.getData(); // 消费
                    System.out.println(MessageFormat.format("{0}*{1}={2}", car.getData(), car.getData(), re));
                    Thread.sleep(r.nextInt(SLEEPTIME));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

}
