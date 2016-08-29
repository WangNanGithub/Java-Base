package com.devil.effective.annotation.inherited;

import java.lang.annotation.Inherited;

/**
 * 
 *
 */
@Inherited
public @interface MyParentObj {
    boolean isInherited() default true; // 设置方法默认值

    String doSomething() default "Do what?";
}
