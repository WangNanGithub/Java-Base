package com.devil.network.udp.qqchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

/**
 * 
 * @author ys
 * @date 2016年5月21日 下午5:16:09
 * @version 1.0.0
 *
 *          UDP多人聊天服务端
 */
public class ChatServer {

	public static void main(String[] args) {
		try (DatagramSocket socket = new DatagramSocket(7000)) {
			while (true) {
				DatagramPacket request = new DatagramPacket(new byte[1024], 0, 1024);// 接收请求的数据包
				socket.receive(request); // 无限阻塞，直到一个UDP数据包发送过来
				String date = new Date().toString() + "\r\n";
				byte[] data = date.getBytes("UTF-8");
				InetAddress host = request.getAddress();
				int port = request.getPort();
				DatagramPacket response = new DatagramPacket(data, data.length, host, port);
				socket.send(response);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
