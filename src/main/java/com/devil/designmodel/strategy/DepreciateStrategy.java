package com.devil.designmodel.strategy;

/**
 * 小幅度降价：打8折
 */
public class DepreciateStrategy implements Strategy {

    @Override
    public double offerPrice(double orgPrice) {
        System.out.println("现在商品小降价");
        return .8 * orgPrice;
    }

}
