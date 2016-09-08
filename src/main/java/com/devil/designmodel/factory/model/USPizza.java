package com.devil.designmodel.factory.model;

public class USPizza implements Pizza{

    @Override
    public void addWater() {
        System.out.println("加100ml水");
    }

    @Override
    public void addFlour() {
        System.out.println("加300克面粉");
    }

    @Override
    public void addSeasoning() {
    }

}
