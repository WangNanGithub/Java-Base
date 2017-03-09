package com.devil.network.tcp;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 
 * @author ys
 * @date 2016年5月17日 下午5:09:34
 * @version 1.0.0
 *
 *          创建连接，获取服务器当前时间
 */
public class DateClient {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("localhost", 7456);// 连接地址和端口号,地址用于找到主机，端口号用于找到对应应用
			InputStreamReader reader = new InputStreamReader(socket.getInputStream());
			int c;
			while ((c = reader.read()) != -1) {
				System.out.print((char) c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
