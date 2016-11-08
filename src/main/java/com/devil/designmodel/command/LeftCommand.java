package com.devil.designmodel.command;

/**
 * 具体命令类：左按钮
 */
public class LeftCommand implements Command {
    private Receiver receiver;

    public LeftCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.left();
    }

}
