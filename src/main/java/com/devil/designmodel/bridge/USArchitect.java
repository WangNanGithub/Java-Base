package com.devil.designmodel.bridge;

// 美国建筑师
public class USArchitect implements Architect {

    @Override
    public void build() {
        System.out.println("this is a USArchitect");
    }

}
