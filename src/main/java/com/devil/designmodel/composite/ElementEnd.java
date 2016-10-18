package com.devil.designmodel.composite;

public class ElementEnd extends Element {

    public ElementEnd(String name) {
        this.name = name;
    }

    @Override
    public void add(Element e) {
        System.out.println("此标签下不能再插入子标签");
    }

    @Override
    public void remove(Element e) {
        System.out.println("此标签下不能删除子标签");
    }

    @Override
    public void show() {
        System.out.println("<" + name + ">");
        System.out.println("</" + name + ">");
    }
}
