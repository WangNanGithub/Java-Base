package com.devil.designmodel.agency.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * @author ys
 * @date 2016年5月3日 下午2:13:54
 * @version 1.0.0
 *
 *          动态生成代理类:通过反射加载结合InvocationHandler实现类的动态代理
 */
public class BusinessImplProxy implements InvocationHandler {
	private Object obj;

	BusinessImplProxy(Object obj) {
		this.obj = obj;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		doBefore();
		result = method.invoke(obj, args);
		doAfter();
		return result;
	}

	public void doBefore() {
		System.out.println("do something before" + obj.getClass() + " Business");
	}

	public void doAfter() {
		System.out.println("do something after" + obj.getClass() + " Business");
	}

	public static Object factory(Object obj) {
		Class<?> cls = obj.getClass();
		return Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(),
				new BusinessImplProxy(obj));
	}
}