package com.devil.network.tcp;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 
 * @author ys
 * @date 2016年5月17日 下午5:08:02
 * @version 1.0.0
 *
 *          当客户端访问时，发送当前时间
 */
public class DateServer {
	public static void main(String[] args) {
		ServerSocket server = null;
		System.out.println("应用启动.....");
		try {
			server = new ServerSocket(7456);//绑定本地的端口号
			while (true) {
				Socket connection = null;
				try {
					connection = server.accept();// 接收一个连接,在没有客户端访问的时候，accept会一直阻塞
					System.out.println("一个连接建立" + connection.getInetAddress());// 获取连接的客户端的地址
					Writer out = new OutputStreamWriter(connection.getOutputStream());// 从连接中获取输出流
					Date date = new Date();
					out.write(date.toString() + "\r\n");
					// 输出流都会有一个缓冲区，比如有一个1024字节的缓冲区
					// 如果缓冲区中的数据量不足1024，那么就会等待，而不会将数据发送给客户端
					// 使用flush()则将缓冲区中的数据强制发送
					out.flush();
					
					Writer ou1t = new OutputStreamWriter(connection.getOutputStream());// 从连接中获取输出流
					ou1t.write(date.toString() + "\r\n");
					ou1t.flush();
					
					Writer ou2t = new OutputStreamWriter(connection.getOutputStream());// 从连接中获取输出流
					ou1t.write(date.toString() + "\r\n");
					ou1t.flush();
					
					connection.close();
				} finally {
					// 必须手动关闭掉
					if (connection != null)
						connection.close();
				}
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
