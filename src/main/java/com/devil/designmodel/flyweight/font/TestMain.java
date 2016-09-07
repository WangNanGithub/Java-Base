package com.devil.designmodel.flyweight.font;

public class TestMain {
    public static void main(String[] args) {
        System.out.println(FontFactory.getNumFont(1, "10", "red"));
        System.out.println(FontFactory.getNumFont(1, "10", "red"));
        System.out.println(FontFactory.getNumFont(2, "10", "red"));
    }
}
