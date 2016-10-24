package com.devil.designmodel.facade;

public class SonyCamera implements Camera{

    @Override
    public void open() {
        System.out.println("打开照相机");
    }

    @Override
    public void takePhoto() {
        System.out.println("拍照");
    }

    @Override
    public void close() {
        System.out.println("关闭照相机");
    }

}
