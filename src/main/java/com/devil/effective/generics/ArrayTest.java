package com.devil.effective.generics;

/**
 * @author Administrator
 * @date 2016年8月26日 上午12:13:36
 * @version $Id$
 *
 *	如果我们一个对象
 * @param <E>
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
