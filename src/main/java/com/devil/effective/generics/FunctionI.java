package com.devil.effective.generics;

import java.util.HashMap;
import java.util.List;

/**
 * 
 *
 * @author yuansheng
 * @version 1.0.0
 * @param <E>
 */
public class FunctionI<E> {
    // 泛型静态工厂
    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<K, V>();
    }

    public void onlyE(List<E> e) {
        for (E e2 : e) {
            System.out.println(e2.getClass().getName());
        }

    }

    // 使用通配符? 如果传进来的参数继承于E，则正确
    public void extendsE(List<? extends E> e) {
        for (E e2 : e) {
            System.out.println(e2.getClass().getName());
        }
    }

    // 使用通配符? 如果传进来的参数是E的父类，则正确
    public void superE(List<? super E> e) {
        for (Object e2 : e) {
            System.out.println(e2.getClass().getName());
        }
    }

    public static <E> void union(List<E> e1, List<E> e2) {
        
    }
}
