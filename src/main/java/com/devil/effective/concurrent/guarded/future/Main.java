package com.devil.effective.concurrent.guarded.future;

import com.devil.effective.concurrent.guarded.RequestQueue;

public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ServerThread(requestQueue, "ServerThread").start(); // 模仿一个服务端
        for (int i = 0; i < 10; i++)
            new ClientThread(requestQueue, "ClientThread" + i).start(); // 多个客户端同时请求,并且每个请求多次
    }
}
