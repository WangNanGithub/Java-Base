package com.devil.designmodel.factory.staticfactory;

public class ChinesePizza implements Pizza {
    @Override
    public void addWater() {
        System.out.println("加100ml水");
    }

    @Override
    public void addFlour() {
        System.out.println("加400克面粉");
    }
}
