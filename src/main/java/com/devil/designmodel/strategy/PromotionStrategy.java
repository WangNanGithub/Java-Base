package com.devil.designmodel.strategy;

/**
 * 促销价：为原价的一半
 */
public class PromotionStrategy implements Strategy {

    @Override
    public double offerPrice(double orgPrice) {
        System.out.println("现在商品促销价");
        return .5 * orgPrice;
    }

}
