package com.devil.designmodel.meditor;

/**
 * 房子
 */
public class House2 extends House {

    public House2(Mediator mediator) {
        super(mediator);
    }

    public void changePrice(int price) {
        this.price = price;
        mediator.changed(this);
    }

}
