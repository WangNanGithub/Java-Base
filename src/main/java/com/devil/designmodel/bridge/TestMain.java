package com.devil.designmodel.bridge;

public class TestMain {
    public static void main(String[] args) {
        Architect cArchitect = new ChineseArchitect();
        Architect uArchitect = new USArchitect();
        Bridge ccbBridge = new ChineseBridge(cArchitect);
        Bridge ucBridge = new USBridge(cArchitect);
        Bridge uuBridge = new USBridge(uArchitect);

        ccbBridge.beBuild();
        System.out.println("=======");
        ucBridge.beBuild();
        System.out.println("=======");
        uuBridge.beBuild();
    }
}
