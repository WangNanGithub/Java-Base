package com.devil.network.tcp.qqchat;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 * 
 * @author ys
 * @date 2016年5月21日 上午8:58:03
 * @version 1.0.0
 *
 *          聊天客户端
 */
public class ChatClient {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("localhost", 7456);// 连接地址和端口号,地址用于找到主机，端口号用于找到对应应用
			DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
			int id = (int) (Math.random() * 1000);
			System.out.println("用户" + id + "与服务器成功建立连接......");
			// 向客户端发送本连接ID
			writer.writeInt(id);

			WriteThread wt = new WriteThread(socket);
			ReadThread rt = new ReadThread(socket);
			// 开启读写分离的线程
			wt.start();
			rt.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
