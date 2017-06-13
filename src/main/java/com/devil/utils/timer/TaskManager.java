package com.devil.utils.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TaskManager {

    private static Timer timer = new Timer();

    public static void main(String[] args) throws InterruptedException {
        timer.schedule(new MyTask(20), 0, 1000);
        Thread.sleep(30000);
        timer.cancel(); // 终止此计时器，丢弃所有当前已安排的任务,schedule就都显示错误
        int num = timer.purge(); // 从此计时器的任务队列中移除所有已取消的任务,返回任务数
        Thread.sleep(10000);
        timer.schedule(new MyTask(20), 0, 1000);
    }

    public static void addTask(TimerTask task, int delay, int period) {
        timer.schedule(task, delay, period);
    }

}

class MyTask extends TimerTask {

    private int time;

    public MyTask(int time) {
        this.time = time;
    }

    @Override
    public void run() {
        if (time < 10) {
            cancel(); // 可以将其移除
            TaskManager.addTask(new MyTask(30), 0, 1000);
        }
        System.out.println(time--);
    }
}