package com.devil.network.tcp;

import java.io.IOException;
import java.net.Socket;

public class SocketConfig {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("time.nist.gov", 13);

			socket.shutdownInput();// close关闭输入和输出，这样只会关闭输入
			socket.shutdownOutput();
			socket.isInputShutdown();// 判断流是否关闭
			socket.isOutputShutdown();
			/**
			 * 设置socket选项
			 */
			socket.setTcpNoDelay(true);// true时，确保包会竟可能快地发送,关闭socket的缓冲
			socket.setSoLinger(true, 300);// 默认socket用close关闭时，如果有未发送的数据，会被丢弃,这里设置了5分钟的阻塞时间
			socket.setSoTimeout(15000);// 设置连接超时时间15秒
			socket.setReceiveBufferSize(1024);// 设置接收缓存区为1024字节
			socket.setSendBufferSize(1024);// 设置发送缓存区为1024字节
			socket.setKeepAlive(true);// true时客户端会通过一个空闲连接来发送数据包(一般两小时一次),以确保服务器未崩溃
			// socket.setOOBInline(true);
			//socket.setReuseAddress(true);
			//socket.setTrafficClass(10);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
