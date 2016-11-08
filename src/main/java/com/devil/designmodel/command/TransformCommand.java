package com.devil.designmodel.command;

/**
 * 具体命令类：转换按钮
 */
public class TransformCommand implements Command {
    private Receiver receiver;

    public TransformCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.transform();
    }

}
