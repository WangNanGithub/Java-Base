package com.devil.effective.concurrent.guarded.future;

import com.devil.effective.concurrent.future.custom.FutureData;
import com.devil.effective.concurrent.future.custom.RealData;
import com.devil.effective.concurrent.guarded.Request;
import com.devil.effective.concurrent.guarded.RequestQueue;

/**
 * 服务端
 */
public class ServerThread extends Thread {
    private RequestQueue requestQueue;

    public ServerThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        while (true) {
            final Request request = requestQueue.getRequest();
            final FutureData future = (FutureData) request.getResponse();
            // RealData的创建比较耗时
            RealData realData = new RealData(request.getName());
            // 处理完，通知客户端
            future.setRealData(realData);
            System.out.println(Thread.currentThread().getName() + " handles " + request);
        }
    }
}
