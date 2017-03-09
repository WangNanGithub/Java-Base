package com.devil.network.inet;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Inet4or6 {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getByName("smtp.163.com");
		System.out.println(address);
		// 区分IPv4和IPv6
		if (address instanceof Inet4Address)
			System.out.println("这个IP地址是IPv4地址!");
		else if (address instanceof Inet6Address)
			System.out.println("这个IP地址是IPv6地址!");
	}
}
