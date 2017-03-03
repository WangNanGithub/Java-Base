package com.devil.juc.concurrent.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用ArrayList来测试
 * 
 * @author Devil
 *
 */
public class ListConcurrentTest {
    private static final int THREAD_POOL_MAX_NUM = 10;
    private List<String> users = new ArrayList<String>();

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
                // this.mList.remove(this.mIndex);
                this.mList.add("...... add " + mIndex + " ......");
            }
        }
    }
}