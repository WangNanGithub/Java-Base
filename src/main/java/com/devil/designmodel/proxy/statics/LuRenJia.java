package com.devil.designmodel.proxy.statics;

public class LuRenJia implements Actor {

    @Override
    public void doAction(int money) {
        System.out.println("收了" + money + "，开始工作");
    }

}
