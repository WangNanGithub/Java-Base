package com.devil.effective.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsClass<K, V> {

    public static void main(String[] args) {
        GenericsClass<String, Object> aClass = new GenericsClass<>();
        List<Integer> list = new ArrayList<Integer>();
        Integer aInteger =aClass.testK(list);
    }

    // 方法泛型与类泛型冲突，不加注解会有警告
    // 这边的K是以传入的list的类型，而不是类中的K类型
    @SuppressWarnings("hiding")
    public <K> K testK(List<K> list) {
        return list.get(0);
    }

    public <T> void testT(List<T> list) {

    }

    public void testV(List<V> list) {

    }

    // T cannot be resolved to a type
    // 编译不通过，方法泛型不能在其他方法上使用
    /*public void testTT(List<T> list){
        
    }*/

    class InClass {
        // 编译通过，内部类可以使用类上的泛型
        public void testK(List<K> list) {

        }
    }

}

class OutClass {
    // K cannot be resolved to a type
    // 编译不通过，类泛型只能在本类中使用
    /*public void testK(List<K> list){
        
    }*/
}
