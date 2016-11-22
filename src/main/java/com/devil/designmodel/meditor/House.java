package com.devil.designmodel.meditor;

/**
 * 房子
 */
public class House extends Colleague {
    private boolean flag = false; // 是否已经出租
    private String name; // 房子名字
    private int price; // 价格

    public House(Mediator mediator, String name) { // 绑定中介和名字
        super(mediator);
        this.name = name;
    }

    // 改变房价
    public void changePrice(int price) {
        this.price = price;
        mediator.changed(this);
    }

    // 租房子
    public boolean rentHouse(String name) {
        if (flag) {
            System.out.println(this.name + "已经出租");
            return false;
        } else {
            System.out.println("房客" + name + "用" + this.price + "租下了" + this.name);
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
