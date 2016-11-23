package com.devil.designmodel.memento;

/**
 * 管理者
 */
public class Caretaker {
    private Memento memento; // 管理的备忘录

    // 存档
    public void save(Memento memento) {
        this.memento = memento;
    }

    public Memento load() {
        return memento;
    }
}
