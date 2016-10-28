package com.devil.effective.concurrent.guarded;

/**
 * 模拟客户端请求
 */
public class ClientThread extends Thread {
    private RequestQueue requestQueue;

    public ClientThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Request request = new Request("RequestID:" + i + " Thread_Name:" + Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + " request " + request);
            requestQueue.addRequest(request);// 提交请求，这是忘队列中添加
            try {
                Thread.sleep(10); // 客户端请求的速度,快于服务端处理速度
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("ClientThread Name is:" + Thread.currentThread().getName());
        }
        System.out.println(Thread.currentThread().getName() + " request end");
    }
}
