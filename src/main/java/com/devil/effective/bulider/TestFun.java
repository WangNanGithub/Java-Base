package com.devil.effective.bulider;

import org.junit.Test;

/**
 * 测试类
 *
 */
public class TestFun {

    /**
     * 测试builder模式
     *
     */
    @Test
    public void testBuilderModel() {
        // builder模式
        NutFacts no = new NutFacts.Builder(1).car(2).so(1).build();
        System.out.println(no);
    }

    /**
     * 测试创建对象对性能的消耗
     *
     * @param
     * @return
     * @throws @author
     * @version 1.0.0
     */
    @Test
    public void testNoUsedObj() {
        // 过多创建对象会增加性能消耗
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            ManeyObj obj = new ManeyObj();
            obj.isBaby();
        }
        System.out.println("消耗:" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            OneObj obj = new OneObj();
            obj.isBaby();
        }
        System.out.println("消耗:" + (System.currentTimeMillis() - start));
        System.out.println("=========");

        // 使用Long会创建对象，而long则不会，这样会减少很多开销

        start = System.currentTimeMillis();
        Long sumL = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sumL += i;
        }
        System.out.println(sumL + "消耗:" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        long suml = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            suml += i;
        }
        System.out.println(suml + "消耗:" + (System.currentTimeMillis() - start));

    }

}
