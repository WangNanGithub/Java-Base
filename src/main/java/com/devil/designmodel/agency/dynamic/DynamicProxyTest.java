package com.devil.designmodel.agency.dynamic;

public class DynamicProxyTest {
	public static void main(String[] args) throws Throwable {
		BusinessFooImpl bfoo = new BusinessFooImpl();
		BusinessFoo bf = (BusinessFoo) BusinessImplProxy.factory(bfoo);
		bf.foo();
		System.out.println();

		bf.too("this is args", " ttttttttooooooo");
		System.out.println();

		BusinessBarImpl bbar = new BusinessBarImpl();
		BusinessBar bb = (BusinessBar) BusinessImplProxy.factory(bbar);
		String message = bb.bar("Hello,World");
		System.out.println(message);
	}
}