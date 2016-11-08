package com.devil.designmodel.command;

/**
 * 请求者类:命令由按钮发起
 */
public class Button {
    private LeftCommand leftCommand;
    private RightCommand rightCommand;
    private ShotCommand shotCommand;
    private TransformCommand transformCommand;

    public void left() {
        leftCommand.execute();
    }

    public void right() {
        rightCommand.execute();
    }

    public void shot() {
        shotCommand.execute();
    }

    public void transform() {
        transformCommand.execute();
    }

    public void setLeftCommand(LeftCommand leftCommand) {
        this.leftCommand = leftCommand;
    }

    public void setRightCommand(RightCommand rightCommand) {
        this.rightCommand = rightCommand;
    }

    public void setShotCommand(ShotCommand shotCommand) {
        this.shotCommand = shotCommand;
    }

    public void setTransformCommand(TransformCommand transformCommand) {
        this.transformCommand = transformCommand;
    }

}
