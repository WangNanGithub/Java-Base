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
		FutureTask<String> futurea = new FutureTask<String>(new Service("a", 200));
		FutureTask<String> futureb = new FutureTask<String>(new Service("b", 30));
		FutureTask<String> futurec = new FutureTask<String>(new Service("c", 50));
		FutureTask<String> futured = new FutureTask<String>(new Service("d", 10));
		FutureTask<String> futuree = new FutureTask<String>(new Service("e", 40));
		ExecutorService executor = Executors.newFixedThreadPool(5);
		// 执行FutureTask,相当于发送一次请求
		// 开启线程进行RealData的call()执行
		executor.submit(futurea);
		executor.submit(futureb);
		executor.submit(futurec);
		executor.submit(futured);
		executor.submit(futuree);
		System.out.println("请求完毕");
		// 这里可以进行额外的操作，这里使用sleep来代替
		Thread.sleep(500);
		System.out.println("Main结束业务");
		// 获取真正的返回信息，如果此时call方法没有执行完成，则依然等待，所以下方按顺序输出
		System.out.println("数据=" + futureb.get());
		System.out.println("数据=" + futurec.get());
		System.out.println("数据=" + futured.get());
		System.out.println("数据=" + futurea.get());
		System.out.println("数据=" + futuree.get());
		executor.shutdown();
	}
}
