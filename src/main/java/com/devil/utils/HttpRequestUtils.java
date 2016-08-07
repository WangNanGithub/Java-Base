package com.devil.utils;

public class HttpRequestUtils {
	private volatile static BaseHttpClient baseHttpClient;
	private volatile static BaseHttpClient baiduHttpClient;
	private volatile static BaseHttpClient testHttpClient;

	public HttpRequestUtils() {
		// TODO Auto-generated constructor stub
	}

	public static BaseHttpClient getBaseInstance() {
		if (baseHttpClient == null) {
			// 只有第一次才彻底执行这里的代码
			synchronized (BaseHttpClient.class) {
				if (baseHttpClient == null)
					baseHttpClient = new BaseHttpClient();
			}
		}
		return baseHttpClient;
	}

	public static BaseHttpClient getTestInstance() {
		if (testHttpClient == null) {
			// 只有第一次才彻底执行这里的代码
			synchronized (BaseHttpClient.class) {
				if (testHttpClient == null)
					testHttpClient = new BaseHttpClient();
			}
		}
		return baseHttpClient;
	}

	public static BaseHttpClient getBaiduInstance() {
		if (baiduHttpClient == null) {
			// 只有第一次才彻底执行这里的代码
			synchronized (BaseHttpClient.class) {
				if (baiduHttpClient == null)
					baiduHttpClient = new BaseHttpClient();
			}
		}
		return baiduHttpClient;
	}

}
