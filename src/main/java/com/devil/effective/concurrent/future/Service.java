package com.devil.effective.concurrent.future;

import java.util.concurrent.Callable;

/**
 * 服务端
 */
public class Service implements Callable<String> {

	private String para;
	private int time; // 休眠时间

	public Service(String para, int time) {
		this.para = para;
	}

	@Override
	public String call() throws Exception {
		// 这里是正真的业务逻辑，需要执行一段时间
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			sBuffer.append(para);
			System.out.println(Thread.currentThread().getName() + "," + para + "執行：" + i);
			Thread.sleep(100 * time);
		}
		return sBuffer.toString();
	}

}
