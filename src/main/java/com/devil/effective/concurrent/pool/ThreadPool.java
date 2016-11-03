package com.devil.effective.concurrent.pool;

import java.util.List;
import java.util.Vector;

/**
 * 
 */
public class ThreadPool {
    private static ThreadPool pool = null;

    // 空闲线程队列
    private List<MyThread> idleThreads;
    // 已有线程总数
    private int count;
    private boolean isShoutDown = false;

    private ThreadPool() {
        this.idleThreads = new Vector<MyThread>(5);
        count = 0;
    }

    public int getCount() {
        return count;
    }

    // 获取线程池实例
    public synchronized static ThreadPool getInstance() {
        if (pool == null)
            pool = new ThreadPool();
        return pool;
    }

    // 将线程放入池中
    protected synchronized void repool(MyThread thread) {
        if (!isShoutDown) {
            idleThreads.add(thread);
        } else {
            thread.shutDown();
        }
    }

    // 停止池中所有线程
    public synchronized void shutDown() {
        isShoutDown = true;
        for (int i = 0; i < idleThreads.size(); i++) {
            MyThread thread = idleThreads.get(i);
            thread.shutDown();
        }
    }

    // 执行任务
    public synchronized void start(Runnable target) {
        MyThread thread = null;
        // 如果有空闲线程，则直接使用
        if (idleThreads.size() > 0) {
            int lastIndex = idleThreads.size() - 1;
            thread = idleThreads.get(lastIndex);
            idleThreads.remove(lastIndex);
            // 执行任务
            thread.setTarget(target);
        } else {
            // 没有空闲线程，则创建新线程
            count++;
            thread = new MyThread(target, "MyThread #" + count, this);
            thread.start();
        }
    }
}
