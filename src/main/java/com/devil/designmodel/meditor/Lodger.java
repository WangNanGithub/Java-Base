package com.devil.designmodel.meditor;

/**
 * 房客
 */
public class Lodger extends Colleague {
    private String house; // 租的房子
    private int staPrice; // 满意的价格
    private String name; // 房客名字

    public Lodger(Mediator mediator, String name, int staPrice) {// 绑定中介和名字及满意的价格
        super(mediator);
        this.name = name;
        this.staPrice = staPrice;
    }

    // 收到房子价格的信息
    public void message(String house, int price) {
        System.out.println(this.name + "收到中介信息---房子:" + house + ",租金:" + price);
        if (this.staPrice == price) {
            // 满意，租房子
            this.house = house;
            mediator.changed(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getHouse() {
        return house;
    }
}
