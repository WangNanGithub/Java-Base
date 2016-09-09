package com.devil.designmodel.decorate;

/**
 * 抹茶粉(具体装饰者)
 *
 */
public class Matcha extends CondimentDecorator {

    public Matcha(Beverage beberage) {
        super(beberage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Matcha";
    }

    @Override
    public double cost() {
        return .5 + beverage.cost();
    }

}
