package com.devil.network.tcp.qqchat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author ys
 * @date 2016年5月21日 上午8:57:15
 * @version 1.0.0
 *
 *          聊天服务端
 */
public class ChatServer {

	public static Map<Integer, Socket> users = new HashMap<>();

	public static void main(String[] args) {
		ServerSocket server = null;
		System.out.println("服务端应用启动.....");
		try {
			server = new ServerSocket(7456);// 绑定本地的端口号
			while (true) {
				Socket connection = null;
				connection = server.accept();// 接收一个连接,在没有客户端访问的时候，accept会一直阻塞
				DataInputStream reader = new DataInputStream(connection.getInputStream());
				int uid = reader.readInt();
				// 获取客户端发来的数据
				System.out.println("一个连接建立:" + connection.getInetAddress() + ",用户ID:" + uid);// 获取连接的客户端的地址
				// 在服务器用户列表中加入一个连接
				users.put(uid, connection);
				ServerThread thread = new ServerThread(reader);
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (server != null)
					server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
