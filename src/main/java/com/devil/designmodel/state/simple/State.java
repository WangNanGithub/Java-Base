package com.devil.designmodel.state.simple;

/**
 * 抽象状态类
 * 
 *
 * @author yuansheng
 * @version 1.0.0
 */
public interface State {
    /**
     * 状态对应的处理
     */
    public void handle(String sampleParameter);
}