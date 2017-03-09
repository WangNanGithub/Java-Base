package com.devil.network.udp.qqchat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 
 * @author ys
 * @date 2016年5月21日 下午5:18:04
 * @version 1.0.0
 *
 *          UDP多人聊天客户端
 */
public class ChatClient2 {
	public static void main(String[] args) {
		// 自己也是开启一个端口,来监听此端口的数据
		try (DatagramSocket socket = new DatagramSocket(7002)) {
			socket.setSoTimeout(10000);// 10秒超时时间
			InetAddress host = InetAddress.getByName("localhost");
			DatagramPacket request = new DatagramPacket(new byte[1], 1, host, 7000);// 建立发送的数据包
			byte[] data = new byte[1024];
			DatagramPacket response = new DatagramPacket(data, data.length);// 接收的数据包
			socket.send(request);// 发送数据包
			socket.receive(response);// 接收数据包
			String result = new String(response.getData(), 0, response.getLength(), "UTF-8");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
