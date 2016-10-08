package com.devil.designmodel.prototype.deep;

public class Test {
	public static void main(String[] args) {
		PSP psp1 = new PSP();
		Account acc = new Account();
		acc.setName("小米");
		acc.setPassword("123");
		psp1.setAccount(acc);
		psp1.setColor("red");
		psp1.setPrice(1600.0);
		psp1.setRam(8);
		System.out.println("小米：" + psp1.toString());

		PSP psp2 = (PSP) psp1.clone();
		System.out.println("小明：" + psp2.toString());

		System.out.println("小明修改内存和账号==========");
		psp2.getAccount().setName("小明");
		psp2.getAccount().setPassword("555");
		psp2.setRam(16);
		System.out.println("小米：" + psp1.toString());
		System.out.println("小明：" + psp2.toString());
	}
}
