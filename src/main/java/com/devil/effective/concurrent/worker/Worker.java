package com.devil.effective.concurrent.worker;

import java.util.Map;
import java.util.Queue;

/**
 * 
 */
public class Worker implements Runnable {

    // 任务队列，用于获取子任务
    protected Queue<Object> workQueue;
    // 子任务处理结果集
    protected Map<String, Object> resultMap;

    public void setWorkQueue(Queue<Object> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    // 子任务处理逻辑，在子类中具体实现
    public Object handle(Object input) {
        return input;
    }

    @Override
    public void run() {
        while (true) {
            // 获取子任务
            Object input = workQueue.poll(); // 获取并移除此队列的头，如果此队列为空，则返回 null。
            if (input == null) {
                break;
            }
            // 处理子任务
            Object re = handle(input);
            System.out.println(re);
            // 将处理结果写入结果集
            resultMap.put(Integer.toString(input.hashCode()), re);
        }
    }

}
