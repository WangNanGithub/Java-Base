package com.devil.designmodel.meditor;

/**
 * 房客抽象类
 */
public abstract class Lodger extends Colleague {

    public Lodger(Mediator mediator) {
        super(mediator);
    }

    public abstract void message(String name, int price);
}
