package com.devil.test;

public class TestCMD {
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("cmd /c start services.msc");
		} catch (Exception e) {
			System.out.println("Error!");
		}
	}
}
