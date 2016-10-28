package com.devil.effective.concurrent.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 客户端
 */
public class LocalUser {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 构建FutureTask
        FutureTask<String> future = new FutureTask<String>(new Service("a"));
        ExecutorService executor = Executors.newFixedThreadPool(1);
        // 执行FutureTask,相当于发送一次请求
        // 开启线程进行RealData的call()执行
        executor.submit(future);
        System.out.println("请求完毕");
        // 这里可以进行额外的操作，这里使用sleep来代替
        Thread.sleep(500);
        System.out.println("Main结束业务");
        // 获取真正的返回信息，如果此时call方法没有执行完成，则依然等待
        System.out.println("数据=" + future.get());
    }
}
