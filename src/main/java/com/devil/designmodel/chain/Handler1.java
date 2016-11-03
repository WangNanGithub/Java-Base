package com.devil.designmodel.chain;

public class Handler1 extends BaseHandler {
    @Override
    protected int getHandleLevel() {
        return 1;
    }

    @Override
    protected void handle(BaseRequest request) {
        System.out.println("Handler1 handle request:" + request.getRequestLevel());
    }

}
