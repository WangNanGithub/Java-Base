package com.devil.designmodel.proxy.dynamic;

//真实角色：真正实现业务逻辑方法
public class BusinessFooImpl implements BusinessFoo {
	public void foo() {
		System.out.println("BusinessFooImpl.foo()");
	}

	@Override
	public void too(String msg, String mm) {
		System.out.println("BusinessFooImpl.too():" + msg + mm);
	}
}