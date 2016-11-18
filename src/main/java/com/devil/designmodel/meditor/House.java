package com.devil.designmodel.meditor;

/**
 * 房子抽象类
 */
public abstract class House extends Colleague {
    protected int price;// 房价

    public House(Mediator mediator) {
        super(mediator);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
