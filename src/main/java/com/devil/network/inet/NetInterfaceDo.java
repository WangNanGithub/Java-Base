package com.devil.network.inet;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class NetInterfaceDo {
	public static void main(String[] args) throws SocketException, UnknownHostException {
		/**
		 * NetworkInterface定义了很多获取本机网络接口信息的方法
		 */
		// 用以太网接口名来获取，UNIX上如：eth0、eth1等
		NetworkInterface ni1 = NetworkInterface.getByName("lo");
		System.out.println(ni1);
		// 用地址来获取
		InetAddress address = InetAddress.getByName("127.0.01");
		NetworkInterface ni2 = NetworkInterface.getByInetAddress(address);
		System.out.println(ni2);
		// 获取本机所有网络接口的程序
		System.out.println("=============================");
		Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
		while (nis.hasMoreElements()) {
			NetworkInterface nini = nis.nextElement();
			System.out.println(nini);
		}
		System.out.println("=============================");
		// 一个网络接口可以绑定多个IP地址,下面列出lo接口的所有ip地址
		NetworkInterface lo = NetworkInterface.getByName("lo");
		Enumeration<InetAddress> addresss = lo.getInetAddresses();
		while (addresss.hasMoreElements()) {
			System.out.println(addresss.nextElement());
		}
	}
}
