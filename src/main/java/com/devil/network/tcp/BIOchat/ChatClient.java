package com.devil.network.tcp.BIOchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 注意用到的输入输出流DataInputStream和DataOutputStream，成对出现，最好用字节流
 */
// 客户端类
public class ChatClient {

	private static int i = 1;

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 7456);
			System.out.println("连接服务器成功......");
			try {
				DataInputStream in = new DataInputStream(socket.getInputStream());
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());

				// 从控制台(System.in)获取输入
				Scanner scanner = new Scanner(System.in);

				while (true) {
					String send = "客户端" + i + ":" + scanner.nextLine();
					System.out.println(send);
					// 把从控制台得到的信息传送给服务器
					out.writeUTF(send);
					// 读取来自服务器的信息
					String accpet = in.readUTF();
					System.out.println(accpet);
				}
			} finally {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}