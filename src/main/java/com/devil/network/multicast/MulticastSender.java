package com.devil.network.multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * 
 * @author ys
 * @date 2016年5月19日 下午2:17:18
 * @version 1.0.0
 *
 *          组播数据发送,发送时开启多个监听者，可以同时收到信息
 */
public class MulticastSender {
	public static void main(String[] args) {
		try {
			InetAddress ia = InetAddress.getByName("239.255.255.250");
			int port = 4000;
			byte ttl = (byte) 1;

			byte[] data = "Here's some multicast data\r\n".getBytes();
			DatagramPacket dp = new DatagramPacket(data, data.length, ia, port);
			try (MulticastSocket ms = new MulticastSocket()) {
				ms.setTimeToLive(ttl);
				ms.joinGroup(ia);
				for (int i = 1; i < 10; i++)
					ms.send(dp);
				ms.leaveGroup(ia);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
