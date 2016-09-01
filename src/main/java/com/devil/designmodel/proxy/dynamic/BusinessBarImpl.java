package com.devil.designmodel.proxy.dynamic;

public class BusinessBarImpl implements BusinessBar {
	public String bar(String message) {
		System.out.println("BusinessBarImpl.bar()");
		return message;
	}

    @Override
    public String barTo(String msg) {
        System.out.println(msg);
        return msg;
    }
}