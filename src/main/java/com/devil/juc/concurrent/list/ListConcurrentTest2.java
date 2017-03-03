package com.devil.juc.concurrent.list;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 使用copyonwriteArrayList来测试
 * 
 * @author Devil
 *
 */
public class ListConcurrentTest2 {
    private static final int THREAD_POOL_MAX_NUM = 10;
    private CopyOnWriteArrayList<String> users = new CopyOnWriteArrayList<String>();

    public void start() {
        // 放入基础信息
        for (int i = 0; i <= THREAD_POOL_MAX_NUM; i++) {
            this.users.add("...... User " + (i + 1) + " ......");
        }
        // 线程池来执行任务
        for (int i = 0; i < THREAD_POOL_MAX_NUM; i++) {
            new Thread(new ListReader(this.users)).start();
            new Thread(new ListWriter(this.users, i)).start();
        }

    }

    private class ListReader implements Runnable {
        private List<String> mList;

        public ListReader(List<String> list) {
            this.mList = list;
        }

        public void run() {
            if (this.mList != null) {
                for (String str : this.mList) {
                    System.out.println(Thread.currentThread().getName() + " : " + str);
                }
            }
        }
    }

    private class ListWriter implements Runnable {
        private List<String> mList;
        private int mIndex;

        public ListWriter(List<String> list, int index) {
            this.mList = list;
            this.mIndex = index;
        }

        public void run() {
            if (this.mList != null) {
                this.mList.add("...... add " + mIndex + " ......");
            }
        }
    }
}