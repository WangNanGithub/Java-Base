package com.devil.effective.generics;

public class ArrayTest<E> {
    public Object[] objs;
    public E[] es;
    public int len = 5;

    public ArrayTest() {
        objs = new Object[len];
        es = (E[]) new Object[len];
    }

}
