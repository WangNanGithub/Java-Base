package com.devil.designmodel.agency.statics;

/**
 * 
 * @author ys
 * @date 2016年5月3日 下午2:08:14
 * @version 1.0.0
 *
 *          代理角色：自己并未实现业务逻辑接口，而是调用真实角色来实现
 */
public class BusinessImplProxy implements Business {
	private BusinessImpl bi;
	// 这里可以定义多个代理的角色：如JummpImpl等

	public void doAction() {
		if (bi == null) {
			bi = new BusinessImpl();
		}
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