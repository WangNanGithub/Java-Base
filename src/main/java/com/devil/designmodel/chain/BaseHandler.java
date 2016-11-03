package com.devil.designmodel.chain;

/**
 * 处理请求的基类
 */
public abstract class BaseHandler {
    protected BaseHandler nextHandler;// 下一个处理者

    /**
     * 处理请求
     */
    public final void handleRequest(BaseRequest request) {
        // 判断当前处理者对象的处理级别是否与请求者的处理级别一致
        if (getHandleLevel() == request.getRequestLevel()) {
            // 如果等级一致，则处理请求
            handle(request);
        } else {
            if (nextHandler != null) {
                // 如果等级不一致，且下面还有处理者，则交给下面处理者处理
                nextHandler.handleRequest(request);
            } else {
                // 当所有处理者都不能处理
                System.out.println("All of handler can not do it");
            }
        }
    }

    /**
     * 获取处理者对象的处理级别
     */
    protected abstract int getHandleLevel();

    /**
     * 每个处理者对象的具体处理方式
     */
    protected abstract void handle(BaseRequest request);
}
