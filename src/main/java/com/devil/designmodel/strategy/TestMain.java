package com.devil.designmodel.strategy;

public class TestMain {
    public static void main(String[] args) {
        Strategy sg1 = new RaiseStrategy();
        VR vr1 = new VR(sg1);
        System.out.println(vr1.getPrice());

        Strategy sg2 = new DepreciateStrategy();
        VR vr2 = new VR(sg2);
        System.out.println(vr2.getPrice());

        Strategy sg3 = new PromotionStrategy();
        VR vr3 = new VR(sg3);
        System.out.println(vr3.getPrice());
    }
}
