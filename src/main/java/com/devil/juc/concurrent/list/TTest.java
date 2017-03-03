package com.devil.juc.concurrent.list;

import org.junit.Test;

public class TTest {
    /**
     * 测试arraylist
     */
    @Test
    public void test1() {
        new ListConcurrentTest().start();
    }

    /**
     * 测试copyOnWriteArraylist
     */
    @Test
    public void test2() {
        new ListConcurrentTest2().start();
    }
}
