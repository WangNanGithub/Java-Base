package com.devil.designmodel.proxy.statics;

public class Test {
	public static void main(String[] args) {
		BusinessImpl impl = new BusinessImpl();
		// 引用变量定义为抽象角色类型
		Business bi = new BusinessImplProxy(impl);
		bi.doAction();
	}
}