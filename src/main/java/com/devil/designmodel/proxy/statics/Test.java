package com.devil.designmodel.proxy.statics;

public class Test {
	public static void main(String[] args) {
		ChenLong impl = new ChenLong();
		// 引用变量定义为抽象角色类型
		Actor bi = new ChenLongProxy(impl);
		bi.doAction(30);
		System.out.println("======");
		bi.doAction(50);
	}
}