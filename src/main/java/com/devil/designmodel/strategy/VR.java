package com.devil.designmodel.strategy;

/**
 * VR设备：环境类
 */
public class VR {

    public double orgPrice = 10000.0; // 商品官方的报价

    private Strategy strategy;

    public VR(Strategy strategy) {
        this.strategy = strategy;
    }

    public double getPrice() {
        return strategy.offerPrice(orgPrice);
    }

}
