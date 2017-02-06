package com.devil.effective.annotation.inherited;

import java.lang.annotation.Inherited;

@Inherited
public @interface MyParentObj {
	
	public enum FontColor {
		BULE, RED, GREEN
	};

	String name();

	FontColor fontColor() default FontColor.GREEN; // default表示默认值
}
