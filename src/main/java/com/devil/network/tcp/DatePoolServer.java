package com.devil.network.tcp;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author ys
 * @date 2016年5月17日 下午5:52:29
 * @version 1.0.0
 *
 *          使用线程池来处理连接，节省时间
 */
public class DatePoolServer {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(50);// 创建50大小的线程池
		try (ServerSocket server = new ServerSocket(7456)) {
			while (true) {
				Socket connection = server.accept();
				Callable<Void> task = new DateTask(connection);
				pool.submit(task);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @author ys
	 * @date 2016年5月17日 下午5:58:14
	 * @version 1.0.0
	 *
	 *          发送日期的任务
	 */
	private static class DateTask implements Callable<Void> {

		private Socket connection;

		public DateTask(Socket connection) {
			this.connection = connection;
		}

		@Override
		public Void call() {
			Writer writer;
			try {
				writer = new OutputStreamWriter(connection.getOutputStream());
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
			return null;
		}
	}
}
