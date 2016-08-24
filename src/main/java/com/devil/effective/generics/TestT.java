package com.devil.effective.generics;

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

        Object[] b = new Object[] { s1, s2 };
        Stu[] bbb = (Stu[]) b;
        
        for (int i = 0; i < b.length; i++) {
            Stu ssStu = array[i];
            System.out.println(ssStu.getId());
        }

        Object o = new Stu();
        Stu stu = (Stu) o;

        Stu[] c = (Stu[]) new Object[] { new Stu(), new Stu(), "123213" };
    }
}
