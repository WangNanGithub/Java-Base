package com.devil.effective.annotation;

import java.util.Calendar;

/**
 * 
 *
 */
public class AnnoTest {

    @ExceptionAnno(value = RuntimeException.class, num = Integer.class, cal = Calendar.class)
    public void testException() {

    }
}
