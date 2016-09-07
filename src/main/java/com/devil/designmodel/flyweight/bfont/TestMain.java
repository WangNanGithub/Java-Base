package com.devil.designmodel.flyweight.bfont;

public class TestMain {
    public static void main(String[] args) {
        System.out.println(FontFactory.getFont("A"));
        System.out.println(FontFactory.getFont("B"));
        System.out.println(FontFactory.getFont("A"));
    }
}
