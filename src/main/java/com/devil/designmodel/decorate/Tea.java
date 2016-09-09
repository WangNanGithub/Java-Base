package com.devil.designmodel.decorate;

/**
 * 
 * 茶叶茶(被装饰者)
 */
public class Tea implements Beverage {

    @Override
    public double cost() {
        return 1.44;
    }

    @Override
    public String getDescription() {
        return "Tea";
    }

}
