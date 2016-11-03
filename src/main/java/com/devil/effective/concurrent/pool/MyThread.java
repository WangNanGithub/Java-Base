package com.devil.effective.concurrent.pool;

public class MyThread extends Thread {
    // 线程池
    private ThreadPool pool;
    // 任务
    private Runnable target;
    private boolean isShutDown = false;
    private boolean isIdle = false;

    public MyThread(Runnable target, String name, ThreadPool pool) {
        super(name);
        this.pool = pool;
        this.target = target;
    }

    public Runnable getTarget() {
        return target;
    }

    public boolean isIdle() {
        return isIdle;
    }

    @Override
    public void run() {
        while (!isShutDown) {
            isIdle = false;
            if (target != null) {
                // 如有任务，则执行
                target.run();
            }
            // 任务结束，到闲置状态
            isIdle = true;
            try {
                // 读任务结束后，不关闭线程，而是放入线程池空闲队列
                pool.repool(this);
                synchronized (this) {
                    // 线程空闲，等待新任务到来
                    wait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            isIdle = false;
        }
    }

    public synchronized void setTarget(Runnable target) {
        this.target = target;
        // 设置任务后，让run方法来执行
        notifyAll();
    }

    // 关闭线程
    public synchronized void shutDown() {
        isShutDown = true;
        notifyAll();
    }
}
