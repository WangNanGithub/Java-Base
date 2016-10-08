package com.devil.effective.pool;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class PoolFactoryDemo implements PooledObjectFactory<Object> {

	private static AtomicInteger counter = new AtomicInteger(0);

	@Override
	public PooledObject<Object> makeObject() throws Exception {
		// 在从池中获取对象的时候如果池中已经没有对象的时候创建
		Object obj = String.valueOf(counter.getAndIncrement());
		System.out.println("Create Obj " + obj);
		PooledObject<Object> pobj = new DefaultPooledObject<Object>(obj);
		return pobj;
	}

	@Override
	public void destroyObject(PooledObject<Object> p) throws Exception {
		System.out.println("销毁前" + p.getObject());
	}

	@Override
	public boolean validateObject(PooledObject<Object> p) {
		return true;
	}

	@Override
	public void activateObject(PooledObject<Object> p) throws Exception {
		System.out.println("取出前"+p.getObject());
	}

	@Override
	public void passivateObject(PooledObject<Object> p) throws Exception {
		System.out.println("对象返回池时"+p.getObject());
	}

}
