package com.devil.designmodel.command;

/**
 * 具体命令类：射击按钮
 */
public class ShotCommand implements Command {
    private Receiver receiver;

    public ShotCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.shot();
    }

}
