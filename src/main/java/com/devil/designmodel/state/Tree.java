package com.devil.designmodel.state;

import java.util.HashMap;
import java.util.Map;

/**
 * 环境角色类
 */
public class Tree {
    // 持有一个State类型的对象实例
    private TreeState state;

    public Map<String, TreeState> states = new HashMap<String, TreeState>();

    public Tree() {
        states.put("grow", new GrowState(this));
        states.put("fruit", new FruitState(this));
        states.put("death", new DeathState(this));

        this.state = states.get("grow");
    }

    public void setState(TreeState state) {
        this.state = state;
    }

    public void handle() {
        state.handle();
    }

}