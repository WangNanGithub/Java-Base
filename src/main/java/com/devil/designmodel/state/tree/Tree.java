package com.devil.designmodel.state.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 环境角色类
 */
public class Tree {
    // 持有一个State类型的对象实例
    private TreeState state;
    // 保存树木一生所有的状态
    public Map<String, TreeState> states = new HashMap<String, TreeState>();
    
    public int growSize;    // 生长可能时间
    public int fruitSize;   // 结果可能时间
    
    public int now = 1; // 当前生长年份

    public Tree() {
        states.put("grow", new GrowState(this));
        states.put("fruit", new FruitState(this));
        states.put("death", new DeathState(this));

        this.state = states.get("grow");
        
        
        // 如果没有环境因素，植物生长和结果是由基因决定的,生长最多5年，最多2年结果
        Random random =new Random();
        growSize =random.nextInt(5);
        fruitSize = random.nextInt(2);
    }

    public void setState(TreeState state) {
        this.state = state;
    }

    public void handle() {
        state.handle();
    }

}