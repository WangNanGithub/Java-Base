package com.devil.effective.concurrent.pool;

import org.junit.Test;

public class Main {
    @Test
    public void normal() {
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 1000; i++) {
            new Thread(new Target("testThread" + i)).start();
        }
        // 大约120ms
    }

    @Test
    public void pool() {
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 1000; i++) {
            ThreadPool.getInstance().start(new Target("testThread" + i));
        }
        // 大约50ms
    }
}
