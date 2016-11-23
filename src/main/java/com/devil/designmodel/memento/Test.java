package com.devil.designmodel.memento;

public class Test {
    public static void main(String[] args) {
        Pokemon pk = new Pokemon();
        // 玩游戏
        pk.play();
        pk.play();
        pk.show();

        // 存盘
        System.out.println("存盘");
        Caretaker ck = new Caretaker();
        ck.save(pk.createMemento());

        // 继续玩
        pk.play();
        pk.play();
        pk.show();

        // 打不过了，读盘
        System.out.println("读盘");
        pk.restore(ck.load());

        pk.show();
    }
}
