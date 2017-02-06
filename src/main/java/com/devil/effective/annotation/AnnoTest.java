package com.devil.effective.annotation;

import java.util.Calendar;

import com.devil.effective.annotation.inherited.MyParentObj;

public class AnnoTest {

    @ExceptionAnno(value = RuntimeException.class, num = Integer.class, cal = Calendar.class)
    public void testException() {

    }
}
