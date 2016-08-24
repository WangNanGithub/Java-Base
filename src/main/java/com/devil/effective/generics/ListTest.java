package com.devil.effective.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 * @author yuansheng
 * @version 1.0.0
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        add(list, 11);
        add(list, "this is a");

        for (String integer : list) {
            System.out.println(integer);
        }
    }

    /**
     * 此方法可以向list中添加数据，但是取值时会报错
     *
     * @param
     * @return
     * @throws @author
     *             yuansheng
     * @version 1.0.0
     */
    public static <E> void add(List list, Object e) {
        list.add(e);
    }
}
