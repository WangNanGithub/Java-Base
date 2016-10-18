package com.devil.designmodel.composite;

public class TestMain {
    public static void main(String[] args) {
        Element root = new ElementCell("root");
        Element c1 = new ElementCell("c1");
        root.add(c1);
        root.add(new ElementCell("c2"));
        c1.add(new ElementCell("c11"));
        Element e1 = new ElementEnd("end1");
        c1.add(e1);
        e1.add(new ElementEnd("123"));
        
        root.show();
        System.out.println("========");
        root.remove(c1);
        root.show();
    }
}
