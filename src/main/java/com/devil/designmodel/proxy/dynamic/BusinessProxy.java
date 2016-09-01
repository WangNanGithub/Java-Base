package com.devil.designmodel.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 *          动态生成代理类:通过反射加载结合InvocationHandler实现类的动态代理
 */
public class BusinessProxy implements InvocationHandler {
	private Object obj;

	BusinessProxy(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		doBefore();
		result = method.invoke(obj, args);
		doAfter();
		return result;
	}

	public void doBefore() {
		System.out.println("do something before" + obj.getClass());
	}

	public void doAfter() {
		System.out.println("do something after" + obj.getClass());
	}

	public static Object factory(Object obj) {
		Class<?> cls = obj.getClass();
		return Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(),
				new BusinessProxy(obj));
	}
}