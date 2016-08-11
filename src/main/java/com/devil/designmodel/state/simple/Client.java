package com.devil.designmodel.state.simple;

/**
 * 客户端类
 * 
 *
 * @author yuansheng
 * @version 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        // 创建状态
        State state = new ConcreteStateB();
        // 创建环境
        Context context = new Context();
        // 将状态设置到环境中
        context.setState(state);
        // 请求
        context.request("test");
    }
}