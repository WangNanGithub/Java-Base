package com.devil.designmodel.proxy.statics;

/**
 * 
 * 代理角色：自己并未实现业务逻辑接口，而是调用真实角色来实现
 */
public class ChenLongProxy implements Actor {
    private Actor bi;
    // 这里可以定义多个代理的角色：如JummpImpl等

    public ChenLongProxy(Actor bi) {
        this.bi = bi;
    }

    @Override
    public void doAction(int money) {
        if (money < 50) {
            System.out.println("钱不够，干个毛？");
        } else {
            System.out.println("经纪人收了20");
            bi.doAction(money - 20);
        }
    }

}