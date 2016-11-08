package com.devil.designmodel.command;

/**
 * 接收者，真正执行具体逻辑
 */
public class Receiver {
    // 向左操作
    public void left() {
        System.out.println("to left");
    }

    // 向右
    public void right() {
        System.out.println("to right");
    }

    // 切换武器
    public void transform() {
        System.out.println("transform weapon");
    }

    // 射击
    public void shot() {
        System.out.println("shot biu biu biu");
    }
}
