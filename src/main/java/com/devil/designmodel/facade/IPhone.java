package com.devil.designmodel.facade;

// 苹果手机
public class IPhone {
    private Phone phone = new TouchPhone();
    private Camera camera = new SonyCamera();

    public void call() {
        phone.call();
    }

    public void videoChat() {
        System.out.println("=======开始视频聊天");
        camera.open();
        phone.call();
    }

    public void takePhoto() {
        camera.open();
        camera.takePhoto();
    }
}
