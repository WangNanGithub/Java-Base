package com.devil.effective.concurrent.pool;

public class Target implements Runnable {
    protected String name;

    public Target(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1);
            System.err.println(System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
