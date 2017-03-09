package com.devil.network.multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * 
 * @author ys
 * @date 2016年5月19日 下午2:05:08
 * @version 1.0.0
 *
 *          组播窃听器
 */
public class MulticastListener {
	public static void main(String[] args) {
		InetAddress group = null;
		int port = 4000;
		try {
			group = InetAddress.getByName("239.255.255.250");// 224.0.0.0-239.255.255.255之间否则抛异常
			MulticastSocket ms = null;
			try {
				ms = new MulticastSocket(port);
				ms.joinGroup(group);

				byte[] buffer = new byte[8192];
				while (true) {
					DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
					ms.receive(dp);
					String s = new String(dp.getData(), "8859_1");
					System.out.println(s);
				}
			} finally {
				if (ms != null) {
					ms.leaveGroup(group);
					ms.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
