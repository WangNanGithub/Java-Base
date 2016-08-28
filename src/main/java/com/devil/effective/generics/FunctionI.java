package com.devil.effective.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public void posh(E e) {

    }

    public E pop() {
        return null;
    }

    // 使用通配符? 如果传进来的参数继承于E，则正确
    // 写E的是模板
    // 而?是一种实例化，是不确定类型的实例化，直接写?，等同于? extends Object
    public void extendsE(List<? extends E> e) {
        for (E obj : e) {
            posh(obj);
        }
    }

    // 使用通配符? 如果传进来的参数是E的父类，则正确

    // 这边有个原则PECS,表示producer-extends，consumer-super
    // extendsE这里是e提供obj给FuncitonI对象的push(E e)使用，所以为生产者，传入push的必须为E的子类
    // superE是e通过FuncitonI使用其pop方法，pop返回的是FuncitonI的泛型E，那么List中的类型就要为E的父类，这样才能转换正确

    public void superE(List<? super E> e) {
        while (!e.isEmpty())
            e.remove(pop());
    }

    public static <E> E popStatic() {
        return null;
    }

    public static <E> void superEstatic(List<? super E> e) {
        while (!e.isEmpty())
            e.remove(popStatic());
    }

    public static <E> List<E> unionUndo(List<E> e1, List<E> e2) {
        return new ArrayList<E>();
    }

    public static <E> List<E> unionExt(List<? extends E> e1, List<? extends E> e2) {
        return new ArrayList<E>();
    }

    // 这样表示E必须继承某个特定类，或实现某个特定接口
    public static <E extends Comparable<E>> E maxOne(List<E> list) {
        return null;
    }

    public static <E extends Comparable<? super E>> E maxTwo(List<? extends E> list) {
        return null;
    }

}
