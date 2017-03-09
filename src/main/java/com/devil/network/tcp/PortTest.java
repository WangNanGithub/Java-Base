package com.devil.network.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Date;

/**
 * 
 * @author ys
 * @date 2016年5月18日 上午10:26:25
 * @version 1.0.0
 *
 *          检查端口是否被使用
 */
public class PortTest {

	public static void main(String[] args) {
		System.out.println(new Date().toString());
		for (int i = 0; i < 65535; i++) {
			try {
				// 如果此端口被使用，则抛异常
				ServerSocket server = new ServerSocket(i, 50);// 监听当前端口，队列一次最多保存50个入站连接,这种方式是否费时
				// ServerSocket ss=new ServerSocket();
				// SocketAddress http=new InetSocketAddress(i);
				// ss.bind(http);
			} catch (IOException e) {
				System.out.println("There is a server on port " + i);
			}
		}
		System.out.println(new Date().toString());
	}
}
