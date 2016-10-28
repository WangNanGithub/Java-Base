package com.devil.effective.concurrent.guarded;

import java.util.LinkedList;

/**
 * 请求队列
 */
public class RequestQueue {
    private LinkedList<Request> queue = new LinkedList<Request>();

    public synchronized void addRequest(Request request) {
        queue.add(request); // 加入新的request请求
        notifyAll(); // 通知getRequest方法
    }

    public synchronized Request getRequest() {
        while (queue.size() == 0) {
            try {
                wait();// 当请求队列为空，进行等待
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return queue.remove(); // 返回第一个，并移除
    }
}
