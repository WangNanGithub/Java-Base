package com.devil.designmodel.meditor;

/**
 * 抽象同事类,关联中介
 */
public abstract class Colleague {
    protected Mediator mediator; // 绑定中介，可以更换

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
        mediator.addColleague(this );
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

}
