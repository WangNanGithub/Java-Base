package com.devil.effective.generics;

import org.junit.Test;

/**
 * 
 *
 * @author yuansheng
 * @version 1.0.0
 */
public class ArrayTest<E> {
    public Object[] objs;
    public E[] es;
    public int len = 5;

    public ArrayTest() {
        objs = new Object[len];
        es = (E[]) new Object[len];
    }

}
