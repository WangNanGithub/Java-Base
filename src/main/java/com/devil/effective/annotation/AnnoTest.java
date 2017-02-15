package com.devil.effective.annotation;

import java.util.Calendar;

import com.devil.effective.annotation.documented.MyDocumented;

public class AnnoTest {

    @ExceptionAnno(value = RuntimeException.class, num = Integer.class, cal = Calendar.class)
    public void testException() {

    }
    
    @MyDocumented("this is a")
    private String a; // 括号内的值，对应的是value属性。可以将注解内的value删除，看看情况
    
    public void test(){
        
    }
}
