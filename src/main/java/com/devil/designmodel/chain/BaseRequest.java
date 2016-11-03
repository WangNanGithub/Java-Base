package com.devil.designmodel.chain;

/**
 * 请求者基类
 */
public abstract class BaseRequest {
    private Object obj;// 处理对象

    public BaseRequest(Object obj) {
        this.obj = obj;
    }

    /**
     * 获取处理的内容对象
     */
    public Object getContent() {
        return obj;
    }

    /**
     * 获取请求级别
     */
    public abstract int getRequestLevel();
}
