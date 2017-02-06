package com.devil.effective.annotation.inherited;

import java.lang.annotation.Annotation;

/**
 * 如果是实现接口的方式，则需要将所有方法都进行重写
 *
 */
public class MyChildObjOld implements MyParentObj {

	@Override
	public Class<? extends Annotation> annotationType() {
		return null;
	}

	@Override
	public String name() {
		return null;
	}

	@Override
	public FontColor fontColor() {
		return null;
	}

}