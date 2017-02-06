package com.devil.test;

import org.junit.Test;

public class JunitTest {
	
	@Test(timeout = 2000)
	public void testTimeout() throws InterruptedException{
		System.out.println("测试2s，超出两秒就异常");
		Thread.sleep(3000);
	}
}
