package com.devil.designmodel.chain;

public class Request2 extends BaseRequest{

    public Request2(Object obj) {
        super(obj);
    }

    @Override
    public int getRequestLevel() {
        return 2;
    }

}
