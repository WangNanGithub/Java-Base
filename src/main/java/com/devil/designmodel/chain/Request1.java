package com.devil.designmodel.chain;

public class Request1 extends BaseRequest {

    public Request1(Object obj) {
        super(obj);
    }

    @Override
    public int getRequestLevel() {
        return 1;
    }

}
