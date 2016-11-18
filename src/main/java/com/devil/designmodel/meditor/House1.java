package com.devil.designmodel.meditor;

/**
 * 房子
 */
public class House1 extends House {

    public House1(Mediator mediator) {
        super(mediator);
    }

    public void changePrice(int price) {
        this.price = price;
        mediator.changed(this);
    }

}
