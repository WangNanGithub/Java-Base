package com.devil.designmodel.composite;

// 标签的基类
public abstract class Element {
    String name;

    public abstract void add(Element e);

    public abstract void remove(Element e);

    public abstract void show();
}
