package com.devil.designmodel.agency.dynamic;

public class BusinessBarImpl implements BusinessBar {
	public String bar(String message) {
		System.out.println("BusinessBarImpl.bar()");
		return message;
	}
}