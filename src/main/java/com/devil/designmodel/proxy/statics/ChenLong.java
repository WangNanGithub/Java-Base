package com.devil.designmodel.proxy.statics;

/**
 *
 * 实现业务逻辑
 */
public class ChenLong implements Actor {

    @Override
    public void doAction(int money) {
        System.out.println("收了" + money + "，开始工作");
    }
}
