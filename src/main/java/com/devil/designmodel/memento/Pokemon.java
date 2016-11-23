package com.devil.designmodel.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 发起人：宠物小精灵游戏
 */
public class Pokemon {
    private String[] defaultSp = new String[10];

    private List<String> playerSp = new ArrayList<String>();

    public void play() {
        int rsp = (int) (Math.random() * 10); // 随机出现精灵
        System.out.println("在野外遇到了" + defaultSp[rsp]);
        int rch = (int) (Math.random() * 100); // 捕获几率
        if (rch > 40) { // 成功捕获的
            System.out.println("成功捕获" + defaultSp[rsp]);
            playerSp.add(defaultSp[rsp]);
            if (playerSp.size() > 6) {
                System.out.println("背包中宠物已经有6只，" + defaultSp[rsp] + "被传送到存储站");
            }
        } else {
            System.out.println("抓捕失败" + defaultSp[rsp] + "逃走了");
        }
        System.out.println("======");
    }

    /**
     * 创建备忘录
     */
    public Memento createMemento() {
        Memento memento = new Memento();
        List<String> copy = new ArrayList<String>();
        copy.addAll(playerSp); // 由于list非基本数据类型，需要进行拷贝
        memento.playerSp = copy;
        return memento;
    }

    /**
     * 恢复游戏
     */
    public void restore(Memento memento) {
        this.playerSp = memento.playerSp;
    }

    /**
     * 展示当前拥有的精灵
     */
    public void show() {
        System.out.println("您当前拥有:");
        for (int i = 0; i < playerSp.size(); i++) {
            System.out.println(playerSp.get(i));
        }
        System.out.println("=====");
    }

    { // 初始化
        defaultSp[0] = "皮卡丘";
        defaultSp[1] = "小拳石";
        defaultSp[2] = "瓦斯弹";
        defaultSp[3] = "暴鲤龙";
        defaultSp[4] = "小火龙";
        defaultSp[5] = "妙蛙种子";
        defaultSp[6] = "水箭龟";
        defaultSp[7] = "超梦";
        defaultSp[8] = "梦幻";
        defaultSp[9] = "喵喵";
    }

}
