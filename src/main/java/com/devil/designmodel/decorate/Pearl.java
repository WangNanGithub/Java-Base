package com.devil.designmodel.decorate;

/**
 *
 * 珍珠(具体装饰者)
 */
public class Pearl extends CondimentDecorator {

    public Pearl(Beverage beberage) {
        super(beberage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Pearl";
    }

    @Override
    public double cost() {
        return .2 + beverage.cost();
    }

}
