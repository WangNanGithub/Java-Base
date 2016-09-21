package com.devil.designmodel.strategy;

/**
 * 提价：供不应求.为原价的1.2倍
 */
public class RaiseStrategy implements Strategy {

    @Override
    public double offerPrice(double orgPrice) {
        System.out.println("现在商品抬价");
        return 1.2 * orgPrice;
    }

}
