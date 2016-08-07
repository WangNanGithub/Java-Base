package com.devil.designmodel.template;

/**
 * 
 * @author ys
 * @date 2016年4月28日 下午6:02:33
 * @version 1.0.0
 *
 *          咖啡因饮料
 */
public abstract class CaffeineBeverage {

	public boolean isClean = true;

	final void prepareRecipe() {
		// final 表示希望子类不能覆盖此方法
		boilWater();
		brew();
		pourInCup();
		addCondiments();
		if (!isClean) { // 挂钩式创建，只有符合条件的时候触发
			cleanUpCup();
		}
	}

	// 冲泡内容和添加的配料都由子类来实现
	abstract void brew();

	abstract void addCondiments();

	private void pourInCup() {
		System.out.println("倒入杯子");

	}

	private void boilWater() {
		System.out.println("烧水");
	}

	public void setClean(boolean isClean) {
		this.isClean = isClean;
	}

	public void cleanUpCup() {
		System.out.println("清洗杯子");
	}

}
