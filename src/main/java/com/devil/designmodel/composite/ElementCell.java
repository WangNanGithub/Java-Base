package com.devil.designmodel.composite;

import java.util.ArrayList;
import java.util.List;
// 结构对象
public class ElementCell extends Element {

    private List<Element> childElement = new ArrayList<Element>();

    public ElementCell(String name) {
        this.name = name;
    }

    @Override
    public void add(Element e) {
        childElement.add(e);
    }

    @Override
    public void remove(Element e) {
        childElement.remove(e);
    }

    @Override
    public void show() {
        System.out.println("<" + name + ">");
        for (Element element : childElement) {
            element.show();
        }
        System.out.println("</" + name + ">");
    }

}
