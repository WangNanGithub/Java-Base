package com.devil.designmodel.decorate;

/**
 * 
 * 奶茶(被装饰者)
 */
public class Milk implements Beverage {

    @Override
    public double cost() {
        return .56;
    }

    @Override
    public String getDescription() {
        return "Milk";
    }
}
