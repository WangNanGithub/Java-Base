package com.devil.designmodel.meditor;

/**
 * 抽象同事类,关联中介
 */
public abstract class Colleague {
    protected Mediator mediator;
    protected String name;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
