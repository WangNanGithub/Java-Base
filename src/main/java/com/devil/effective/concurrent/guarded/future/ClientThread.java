package com.devil.effective.concurrent.guarded.future;

import java.util.ArrayList;
import java.util.List;

import com.devil.effective.concurrent.future.custom.FutureData;
import com.devil.effective.concurrent.guarded.Request;
import com.devil.effective.concurrent.guarded.RequestQueue;

/**
 * 客户端
 */
public class ClientThread extends Thread {
    private RequestQueue requestQueue;
    private List<Request> myRequest = new ArrayList<Request>();

    public ClientThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        // 先提出请求
        for (int i = 0; i < 10; i++) {
            Request request = new Request("RequestID:" + i + " Thread_Name" + Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + " requests " + request);
            // 设置一个FutureData的返回值
            request.setResponse(new FutureData());
            requestQueue.addRequest(request);
            // 发送请求
            myRequest.add(request);
            // 额外的业务处理，等待服务器装配数据
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 取得服务端的返回值
        for (Request request : myRequest) {
            // 如果服务端还没处理完，这里会等待
            System.out.println("ClientThread Name is:" + Thread.currentThread().getName() + " Reponse is:" + request.getResponse().getResult());
        }
    }
}
