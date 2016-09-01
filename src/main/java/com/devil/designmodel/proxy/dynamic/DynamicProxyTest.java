package com.devil.designmodel.proxy.dynamic;

public class DynamicProxyTest {
	public static void main(String[] args) throws Throwable {
		BusinessFooImpl bfoo = new BusinessFooImpl();
		BusinessFoo bf = (BusinessFoo) JDKProxy.factory(bfoo);
		bf.foo();
		System.out.println();

		bf.too("this is args", " ttttttttooooooo");
		System.out.println();

		BusinessBarImpl bbar = new BusinessBarImpl();
		BusinessBar bb = (BusinessBar) JDKProxy.factory(bbar);
		bb.bar("Hello,World");
		bb.barTo("Hello,World");
	}
}