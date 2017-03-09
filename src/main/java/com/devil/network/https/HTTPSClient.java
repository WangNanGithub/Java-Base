package com.devil.network.https;

import java.io.*;
import javax.net.ssl.*;

/**
 * 
 * @author ys
 * @date 2016年5月18日 下午3:08:46
 * @version 1.0.0
 *
 *          用SSLSocketFactory创建安全socket
 */
public class HTTPSClient {

	public static void main(String[] args) {

		int port = 443; // 默认的https端口
		String host = "localhost";

		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		SSLSocket socket = null;
		try {
			socket = (SSLSocket) factory.createSocket(host, port);

			// 启动所有密码组
			String[] supported = socket.getSupportedCipherSuites();
			//String[] sutites={"SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA"};
			// socket.setEnabledCipherSuites(sutites);//设置密码组
			socket.setEnabledCipherSuites(supported);

			Writer out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			// https在GET行中需要完全的URL
			out.write("GET http://" + host + "/ HTTP/1.1\r\n");
			out.write("Host: " + host + "\r\n");
			out.write("\r\n");
			out.flush();

			// 读取响应
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 读取首部
			String s;
			while (!(s = in.readLine()).equals("")) {
				System.out.println(s);
			}
			// 读取长度
			String contentLength = in.readLine();
			int length = Integer.MAX_VALUE;
			try {
				length = Integer.parseInt(contentLength.trim(), 16);
			} catch (NumberFormatException ex) {
				// 没有发送 content-length
				// 这个服务器在响应体的第一行
			}
			System.out.println(contentLength);

			int c;
			int i = 0;
			while ((c = in.read()) != -1 && i++ < length) {
				System.out.write(c);
			}

			System.out.println();
		} catch (IOException ex) {
			System.err.println(ex);
		} finally {
			try {
				if (socket != null)
					socket.close();
			} catch (IOException e) {
			}
		}
	}
}