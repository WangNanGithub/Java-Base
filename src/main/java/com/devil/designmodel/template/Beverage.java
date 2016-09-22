package com.devil.designmodel.template;

/**
 * 热饮
 */
public abstract class Beverage {

    final void prepareRecipe() {
        // final 表示希望子类不能覆盖此方法
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // 冲泡内容和添加的配料都由子类来实现
    abstract void brew();

    abstract void addCondiments();

    private void pourInCup() {
        System.out.println("将热饮倒入杯子");
    }

    private void boilWater() {
        System.out.println("烧水");
    }

}
