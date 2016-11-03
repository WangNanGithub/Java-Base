package com.devil.designmodel.chain;

public class Handler2 extends BaseHandler {
    @Override
    protected int getHandleLevel() {
        return 2;
    }

    @Override
    protected void handle(BaseRequest request) {
        System.out.println("Handler2 handle request:" + request.getRequestLevel());
    }

}
