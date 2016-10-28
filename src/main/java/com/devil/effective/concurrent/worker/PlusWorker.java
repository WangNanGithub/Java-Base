package com.devil.effective.concurrent.worker;

/**
 * 具体实现处理方法，求立方和
 */
public class PlusWorker extends Worker {
    @Override
    public Object handle(Object input) {
        Integer i = (Integer) input;
        return i * i * i;
    }
}
