package com.devil.designmodel.chain;

public class Request3 extends BaseRequest {

    public Request3(Object obj) {
        super(obj);
    }

    @Override
    public int getRequestLevel() {
        return 3;
    }

}
