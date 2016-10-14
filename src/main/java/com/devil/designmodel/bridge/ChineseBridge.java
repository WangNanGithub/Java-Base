package com.devil.designmodel.bridge;
// 中国桥
public class ChineseBridge implements Bridge {

    private Architect architect;

    public ChineseBridge(Architect architect) {
        this.architect = architect;
    }

    @Override
    public void beBuild() {
        architect.build();
        System.out.println("buil a ChinaBridge");
    }

}
