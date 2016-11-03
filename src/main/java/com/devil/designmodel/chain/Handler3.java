package com.devil.designmodel.chain;

public class Handler3 extends BaseHandler {
    @Override
    protected int getHandleLevel() {
        return 3;
    }

    @Override
    protected void handle(BaseRequest request) {
        System.out.println("Handler3 handle request:" + request.getRequestLevel());
    }

}
