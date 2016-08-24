package com.devil.effective.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

/**
 * 
 *
 * @author yuansheng
 * @version 1.0.0
 */
public class TestT {
    @Test
    public void test1() {
        ArrayTest<Stu> stu = new ArrayTest<Stu>();
        Stu s1 = new Stu();
        s1.setId(1);
        Stu s2 = new Stu();
        s2.setId(2);
        stu.objs[0] = s1;
        stu.objs[1] = s2;
        stu.es[0] = (Stu) s1;
        stu.es[1] = (Stu) s2;
        Object object = new Stu();

        System.out.println(((Stu) stu.objs[0]).getId());
        System.out.println(((Stu) stu.es[1]).getId());
    }

    @Test
    public void test2() {
        Stu s1 = new Stu();
        s1.setId(1);
        Stu s2 = new Stu();
        s2.setId(2);
        Object[] a = new Stu[] { new Stu(), new Stu() };
        Stu[] array = (Stu[]) a;

        Object[] b = new Object[] { s1, s2, "123" };
        System.out.println(b[0] instanceof Object);
        System.out.println(b[0] instanceof Stu);
        Stu tt = (Stu) b[0];
        System.out.println(tt.getId());
        Stu[] bbb = (Stu[]) b;

        for (int i = 0; i < b.length; i++) {
            Stu ssStu = array[i];
            System.out.println(ssStu.getId());
        }

        Object o = new Stu();
        Stu stu = (Stu) o;

        Stu[] c = (Stu[]) new Object[] { new Stu(), new Stu()};
    }

    @Test
    public void test3() {
        Stuc s1 = new Stuc();
        System.out.println(s1 instanceof Stuc);
        System.out.println(s1 instanceof Stu);
//        Stuc stuc = (Stuc) new Stu();
        Stu stuc = new Stuc();
        (Stu) stuc;
    }

    @Test
    public void testFunNewHashMap() {
        // 老办法创建map，这样每次new的时候都需要制定类型
        HashMap<String, Stu> oldmap = new HashMap<String, Stu>();

        // 通过泛型静态工厂方法来创建,十分简洁
        HashMap<String, Stu> map = FunctionI.newHashMap();
    }

    @Test
    public void testExtendsE() {
        FunctionI<Stu> fun = new FunctionI<Stu>();
        // 如果list中的类型是继承fun的则可以运行
        List<Stuc> list = new ArrayList<Stuc>();
        list.add(new Stuc());
        // fun.onlyE(list); // 编译不通过
        fun.extendsE(list);
        // fun.superE(list);// 编译不通过
        // 如果不是继承的
        List<Stu> list2 = new ArrayList<Stu>();
        list2.add(new Stu());
        fun.onlyE(list2);
        fun.extendsE(list2);
        fun.superE(list2);
    }
    
    @Test
    public void testunion(){
        List<Integer> list1=new ArrayList<Integer>();
    }

}
