package com.devil.designmodel.command;

/**
 * 具体命令类：右按钮
 */
public class RightCommand implements Command {
    private Receiver receiver;

    public RightCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.right();
    }

}
