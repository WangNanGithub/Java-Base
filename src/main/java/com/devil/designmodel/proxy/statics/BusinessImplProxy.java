package com.devil.designmodel.proxy.statics;

/**
 * 
 * 代理角色：自己并未实现业务逻辑接口，而是调用真实角色来实现
 */
public class BusinessImplProxy implements Business {
	private Business bi;
	// 这里可以定义多个代理的角色：如JummpImpl等

	public BusinessImplProxy(Business bi){
		this.bi=bi;
	}

	public void doAction() {
		doBefore();
		bi.doAction();
		doAfter();
	}

	public void doBefore() {
		System.out.println("前置处理！");
	}

	public void doAfter() {
		System.out.println("后置处理！");
	}
}