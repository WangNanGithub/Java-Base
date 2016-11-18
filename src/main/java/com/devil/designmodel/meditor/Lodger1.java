package com.devil.designmodel.meditor;

/**
 * 房客
 */
public class Lodger1 extends Lodger {

    public Lodger1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void message(String name, int price) {
        System.out.println("收到中介信息---房子:" + name + ",租金:" + price);
        if (price == 500) {
            // 满意，租房子
            System.out.println("房客" + this.name + "花500租下了" + name);
        }
    }
}
