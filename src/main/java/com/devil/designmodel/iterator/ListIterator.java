package com.devil.designmodel.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 针对list的迭代器
 */
public class ListIterator<T> implements MyIterator<T> {
    private List<T> list = new ArrayList<T>();
    private int cursor = 0;

    @Override
    public boolean hashNext() {
        return cursor != list.size();
    }

    @Override
    public T next() {
        T obj = null;
        if (hashNext()) {
            obj = list.get(cursor++); // 获取下个值，并且游标+1
        }
        return obj;
    }

}
