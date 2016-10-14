package com.devil.designmodel.bridge;
// 美国桥
public class USBridge implements Bridge {

    private Architect architect;

    public USBridge(Architect architect) {
        this.architect = architect;
    }

    @Override
    public void beBuild() {
        architect.build();
        System.out.println("build a USBridge");
    }

}
