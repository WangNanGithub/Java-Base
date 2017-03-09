package com.devil.network.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressHost {
	public static void main(String[] args) throws UnknownHostException {
		/**
		 * java.net.InetAddress是java对ip地址（包括IPv4和IPv6）的高层表示。
		 * 包括socket、serversocket、url、datagramsocket、datagrampackage等都要用到 一般的讲，它包含一个主机名和一个IP地址
		 */
		InetAddress address = InetAddress.getByName("www.baidu.com");
		System.out.println(address);
		
		address = InetAddress.getByName("116.239.211.112");
		System.out.println(address);
		// 一个主机多个地址
		InetAddress[] addresss = InetAddress.getAllByName("www.baidu.com");
		for (InetAddress inetAddress : addresss) {
			System.out.println(inetAddress);
		}
		// 本地地址
		InetAddress local = InetAddress.getLocalHost();
		System.out.println(local);
		// 通过address，可以为不存在或无法解析的主机创建地址
		byte[] add = { 115, (byte) 239, (byte) 211, 112 };
		InetAddress addr = InetAddress.getByAddress(add);
		System.out.println(addr);
		InetAddress hostaddr = InetAddress.getByAddress("www.baidu.com", add);
		System.out.println(hostaddr);
		
	}
}
