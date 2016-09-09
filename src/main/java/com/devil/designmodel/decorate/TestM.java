package com.devil.designmodel.decorate;

public class TestM {
    public static void main(String[] args) {
        Beverage be = new Tea();
        System.out.println(be.getDescription() + "---" + be.cost());
        Beverage b2 = new Pearl(new Milk());
        System.out.println(b2.getDescription() + "---" + b2.cost());
        b2 = new Matcha(b2);
        System.out.println(b2.getDescription() + "---" + b2.cost());
    }
}
