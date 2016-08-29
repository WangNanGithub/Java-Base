package com.devil.effective.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Calendar;

/**
 * 
 *
 */
@Retention(value = RetentionPolicy.RUNTIME) // @Retention中有属性value，value=可以要也可以不要
@Target({ ElementType.METHOD, ElementType.PACKAGE }) // 可以放多个
public @interface ExceptionAnno {

    Class<? extends Exception>[] value();

    Class<? extends Number> num();

    Class<? extends Calendar> cal() default Calendar.class; // 设置默认值，则该项在使用注解的时候非必填
}
