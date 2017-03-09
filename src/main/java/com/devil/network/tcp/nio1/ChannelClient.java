package com.devil.network.tcp.nio1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * 
 * @author ys
 * @date 2016年5月17日 下午5:09:34
 * @version 1.0.0
 *
 *          创建连接，获取服务器当前时间
 */
public class ChannelClient {
	// 信道选择器
	private Selector selector;

	// 与服务器通信的信道
	SocketChannel socketChannel;

	// 要连接的服务器Ip地址
	private String hostIp;

	// 要连接的远程服务器在监听的端口
	private int hostListenningPort;

	public ChannelClient(String HostIp, int HostListenningPort) throws IOException {
		this.hostIp = HostIp;
		this.hostListenningPort = HostListenningPort;

		initialize();
	}

	/**
	 * 初始化
	 * 
	 * @throws IOException
	 */
	private void initialize() throws IOException {
		// 打开监听信道并设置为非阻塞模式
		socketChannel = SocketChannel.open(new InetSocketAddress(hostIp, hostListenningPort));
		socketChannel.configureBlocking(false);

		// 打开并注册选择器(监听读)到信道
		selector = Selector.open();
		socketChannel.register(selector, SelectionKey.OP_READ);

		// 启动读取线程
		ChannelClientReadThread ccrt = new ChannelClientReadThread(selector);
		ccrt.start();
	}

	/**
	 * 发送字符串到服务器
	 * 
	 * @param message
	 * @throws IOException
	 */
	public void sendMsg(String message) throws IOException {
		ByteBuffer writeBuffer = ByteBuffer.wrap(message.getBytes("UTF-8"));
		socketChannel.write(writeBuffer);
	}

	static ChannelClient client;
	static boolean mFlag = true;

	public static void main(String[] args) throws IOException {
		client = new ChannelClient("localhost", 7456);
		try {
			client.sendMsg("我是客户端");
			while (mFlag) {
				Scanner scan = new Scanner(System.in);// 键盘输入数据
				String string = scan.nextLine();
				client.sendMsg(string);
			}
		} catch (IOException e) {
			mFlag = false;
			e.printStackTrace();
		} finally {
			mFlag = false;
		}
	}
}
