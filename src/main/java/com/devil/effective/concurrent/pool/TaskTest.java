package com.devil.effective.concurrent.pool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TaskTest {
    static ScheduledThreadPoolExecutor stpe = null; // 池
    static int index;

    public static void main(String[] args) {
        // 构造一个ScheduledThreadPoolExecutor对象，并且设置它的容量为5个
        stpe = new ScheduledThreadPoolExecutor(5);
        MyTask task = new MyTask();
        // 隔2秒后开始执行任务，并且在上一次任务开始后隔一秒再执行一次；
        // stpe.scheduleWithFixedDelay(task, 2, 1, TimeUnit.SECONDS);
        // 隔6秒后执行一次，但只会执行一次。

        // 使用时，注释一个，放开另一个
        for (int i = 1; i < 15; i++) {
            stpe.schedule(task, i, TimeUnit.SECONDS);
        }

        MyCallable mc = new MyCallable();
        for (int i = 0; i < 15; i++) {
            stpe.schedule(mc, i, TimeUnit.SECONDS);
        }
    }

    private static String getTimes() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        return format.format(date);
    }

    private static class MyTask implements Runnable {

        @Override
        public void run() {
            index++;
            System.out.println("2= " + getTimes() + " " + index);
            if (index >= 10) {
                stpe.shutdownNow();
                if (stpe.isShutdown()) {
                    System.out.println("停止了？？？？");
                }
            }
        }
    }

    private static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            index++;
            String res = "" + index;
            System.out.println("2= " + getTimes() + " " + index);
            if (index >= 10) {
                stpe.shutdown();
                if (stpe.isShutdown()) {
                    System.out.println("停止了？？？？");
                }
            }
            return res;
        }

    }

}