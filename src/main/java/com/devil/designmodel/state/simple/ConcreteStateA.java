package com.devil.designmodel.state.simple;

/**
 * 具体状态类
 * 
 *
 * @author yuansheng
 * @version 1.0.0
 */
public class ConcreteStateA implements State {

    @Override
    public void handle(String sampleParameter) {

        System.out.println("ConcreteStateA handle ：" + sampleParameter);
    }

}