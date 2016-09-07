package com.devil.designmodel.proxy.dynamic;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLIBProxy implements MethodInterceptor {
	private Object obj;

	public CGLIBProxy(Object obj) {
		this.obj = obj;
	}

	public Object factory() {
		Enhancer enhancer = new Enhancer();
		// 通过字节码技术动态创建子类实例
		enhancer.setSuperclass(obj.getClass());
		// 回调方法
		enhancer.setCallback(this);
		// 创建代理对象
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("do before");
		// 通过代理类调用父类中的方法
		Object result = proxy.invokeSuper(obj, args);
		System.out.println("do after");
		return result;
	}

}
