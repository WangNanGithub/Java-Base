package com.devil.designmodel.command;

import java.util.Scanner;

public class Player {
    public static void main(String[] args) {
        // 最终接受者
        Receiver receiver = new Receiver();

        // 命令
        LeftCommand leftCommand = new LeftCommand(receiver);
        RightCommand rightCommand = new RightCommand(receiver);
        ShotCommand shotCommand = new ShotCommand(receiver);
        TransformCommand transformCommand = new TransformCommand(receiver);

        // 设置按钮
        Button button = new Button();
        button.setTransformCommand(transformCommand);
        button.setLeftCommand(leftCommand);
        button.setRightCommand(rightCommand);
        button.setShotCommand(shotCommand);

        Scanner scan = new Scanner(System.in);
        while (true) {
            String read = scan.nextLine();
            switch (read) {
            case "w":
                button.shot();
                break;
            case "s":
                button.transform();
                break;
            case "a":
                button.right();
                break;
            case "d":
                button.left();
                break;
            default:
                break;
            }
        }

    }
}
