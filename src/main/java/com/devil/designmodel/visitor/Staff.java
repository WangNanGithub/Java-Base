package com.devil.designmodel.visitor;

import java.util.Random;

/**
 * 员工基类
 */
public abstract class Staff {
    public String name;
    public int kpi; // 业绩指标

    public Staff(String name) {
        this.name = name;
        kpi = new Random().nextInt(10);
    }

    // 接受Visitor访问
    public abstract void accept(Visitor visitor);
}
