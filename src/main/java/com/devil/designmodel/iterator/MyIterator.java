package com.devil.designmodel.iterator;

/**
 * 迭代器接口
 */
public interface MyIterator<T> {
    
    boolean hashNext();

    T next();
}
