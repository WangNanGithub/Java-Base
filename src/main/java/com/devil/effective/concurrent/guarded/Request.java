package com.devil.effective.concurrent.guarded;

import com.devil.effective.concurrent.future.custom.Data;

/**
 * 请求模拟类
 */
public class Request {
    private String name;
    private Data response;

    public Request(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized void setResponse(Data response) {
        this.response = response;
    }

    public synchronized Data getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "[ Request " + name + "]";
    }
}
