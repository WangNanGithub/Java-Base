package com.devil.network.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;
import java.util.logging.Logger;

public class UDPServer {

	private static Logger logger = Logger.getLogger("requset");

	public static void main(String[] args) {
		logger.info(new Date().toString());
		try (DatagramSocket socket = new DatagramSocket(7456)) {
			DatagramPacket request = new DatagramPacket(new byte[1024], 0, 1024);// 接收请求的数据包
			socket.receive(request); // 无限阻塞，直到一个UDP数据包发送过来
			String date = new Date().toString() + "\r\n";
			byte[] data = date.getBytes("UTF-8");
			InetAddress host = request.getAddress();
			int port = request.getPort();
			DatagramPacket response = new DatagramPacket(data, data.length, host, port);
			socket.send(response);
			logger.info(date + " " + request.getAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
