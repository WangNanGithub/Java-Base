package com.devil.designmodel.decorate;

/**
 * 
 * 调料(装饰者)
 */
public abstract class CondimentDecorator implements Beverage {
    Beverage beverage;

    public CondimentDecorator(Beverage beberage) {
        this.beverage = beberage;
    }

}
