package com.devil.designmodel.proxy.dynamic;

public class DynamicProxyTest {
	public static void main(String[] args) throws Throwable {
		// JDK
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

		// CGLIB
		System.out.println("cglib");
		BusniessCGLIB buso = new BusniessCGLIB();
		buso.doAction();
		CGLIBProxy cglib = new CGLIBProxy(buso);
		BusniessCGLIB bus = (BusniessCGLIB) cglib.factory();
		bus.doAction();
	}
}