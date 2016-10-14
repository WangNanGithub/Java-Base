package com.devil.designmodel.bridge;

// 中国建筑师
public class ChineseArchitect implements Architect {

    @Override
    public void build() {
        System.out.println("this is a ChineseArchitect");
    }

}
