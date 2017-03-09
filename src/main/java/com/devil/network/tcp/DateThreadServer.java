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
 * @date 2016年5月17日 下午5:23:46
 * @version 1.0.0
 *
 *          如果用普通形式创建连接，当访问数量多的时候会有用户被前面用户阻塞，这里使用多线程来解决这个问题
 */
public class DateThreadServer {
	public static void main(String[] args) {
		ServerSocket server = null;
		System.out.println("应用启动.....");
		try {
			server = new ServerSocket(7456);
			while (true) {
				Socket connection = null;
				try {
					connection = server.accept();// 接收一个连接
					System.out.println("一个连接建立" + connection.getInetAddress());
					DateThread task = new DateThread(connection);
					task.start();
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

	/**
	 * 创建连接的线程
	 * 
	 * @author ys
	 * @date 2016年5月17日 下午5:27:17
	 * @version 1.0.0
	 *
	 */
	private static class DateThread extends Thread {
		private Socket connection;

		public DateThread(Socket connection) {
			this.connection = connection;
		}

		@Override
		public void run() {
			try {
				Writer writer = new OutputStreamWriter(connection.getOutputStream());
				Date now = new Date();
				writer.write(now.toString() + "\r\n");
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (connection != null)
						connection.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
