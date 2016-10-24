package com.devil.designmodel.facade;

// 触摸屏手机
public class TouchPhone implements Phone{

    @Override
    public void call() {
        System.out.println("点击触摸屏拨号");
    }

}
