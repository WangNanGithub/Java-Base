package com.devil.effective.concurrent.worker;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 求1-100的各个数字立方和
 * 创建5个Worker进程和实例，并提交100个任务
 */
public class Client {
    public static void main(String[] args) {
        Master master = new Master(new PlusWorker(), 5);
        for (int i = 0; i < 100; i++)
            master.submit(i);
        master.execute();// 开启master
        int re = 0; // 保存最终结果
        Map<String, Object> resultMap = master.getResultMap();
        while (resultMap.size() > 0 || !master.isComplete()) {
            Set<String> keys = resultMap.keySet();
            Iterator<String> iterator = keys.iterator();
            String key = null;
            if (iterator.hasNext()) {
                key = iterator.next();
            }
            Integer i = null;
            if (key != null) {
                i = (Integer) resultMap.get(key);
            }
            if (i != null) {
                re += i;
            }
            if (key != null) {
                resultMap.remove(key);// 移除已被计算过的项
            }
        }
    }
}
