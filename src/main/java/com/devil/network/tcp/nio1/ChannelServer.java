package com.devil.network.tcp.nio1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * @author ys
 * @date 2016年5月18日 上午8:51:42
 * @version 1.0.0
 *
 *          Selector（选择器）是Java
 *          NIO中能够检测一到多个NIO通道，并能够知晓通道是否为诸如读写事件做好准备的组件。这样，一个单独的线程可以管理多个channel，从而管理多个网络连接。
 */
public class ChannelServer {

	public static void main(String[] args) {
		ServerSocketChannel serverChannel;
		Selector selector;
		try {
			serverChannel = ServerSocketChannel.open(); // 打开监听信道,ServerSocketChannel最终实现的是channel接口
			ServerSocket serverSocket = serverChannel.socket(); // 创建一个服务端socket
			InetSocketAddress address = new InetSocketAddress(7456);
			serverSocket.bind(address); // 绑定IP及端口
			serverChannel.configureBlocking(false);// 设置为非阻塞方式,如果为true 那么就为传统的阻塞方式
			selector = Selector.open();// 静态方法 实例化selector 创建选择器
			/**
			 * 必须将channel注册到selector上,注册OP_ACCEPT事件
			 * register()方法的第二个参数。这是一个“interest集合”，意思是在通过Selector监听Channel时对什么事件感兴趣。
			 * 如果你对不止一种事件感兴趣，那么可以用“位或”操作符将常量连接起来 int interestSet =SelectionKey.OP_READ |
			 * SelectionKey.OP_WRITE;
			 */
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("服务端启动......");
			while (true) {
				try {
					// 等待某信道就绪(或超时) 监听注册通道，当其中有注册的 IO操作可以进行时，该函数返回 并将对应的SelectionKey加入selected-key
					int s = 0;
					// s=selector.select();
					if ((s = selector.select(3000)) == 0) {
						// System.out.println("重新等待");
						continue;
					}
					// System.out.println(s);// 接收到连接时(因为上面的注册时间是OP_ACCEPT)会一直打印,每增加一个连接,s+1
				} catch (IOException ex) {
					ex.printStackTrace();
					break;
				}

				Set<SelectionKey> readyKeys = selector.selectedKeys();// selectedKeys()中包含了每个准备好某一I/O操作的信道的SelectionKey
				Iterator<SelectionKey> iterator = readyKeys.iterator();// Selected-key代表了所有通过select()方法监测到可以进行IO操作的channel
				while (iterator.hasNext()) {// 对每个信道进行一次循环，查看各个信道是否有事件需要处理
					SelectionKey key = iterator.next();
					iterator.remove();
					try {
						if (key.isAcceptable()) { // 有客户端连接请求时
							ServerSocketChannel server = (ServerSocketChannel) key.channel();
							SocketChannel client = server.accept();
							System.out.println("接收到连接:" + client);
							client.configureBlocking(false);
							SelectionKey clientKey = client.register(selector,
									SelectionKey.OP_WRITE | SelectionKey.OP_READ);
							ByteBuffer buffer = ByteBuffer.allocate(1024);// 分配一个新的1024字节的缓冲区
							clientKey.attach(buffer);// 将给定的缓冲区附加到此键
						}
						if (key.isReadable()) {// 判断是否有数据发送过来
							SocketChannel client = (SocketChannel) key.channel();
							ByteBuffer buffer = (ByteBuffer) key.attachment();
							buffer.clear();
							// 读取信息获得读取的字节数
							long bytesRead = client.read(buffer);
							if (bytesRead == -1) {
								// 没有读取到内容的情况
								client.close();
							} else {
								// 将缓冲区准备为数据传出状态
								buffer.flip();
								// 将字节转化为为UTF-8的字符串
								String receivedString = Charset.forName("UTF-8").newDecoder()
										.decode(buffer).toString();
								// 控制台打印出来
								System.out.println(
										"信息来源:" + client.socket().getRemoteSocketAddress());
								System.out.println("信息内容:" + receivedString);
								String sendString = "你好,已经收到你的信息" + receivedString;// 准备发送的文本
								buffer = ByteBuffer.wrap(sendString.getBytes("UTF-8"));// 将byte数组包装到缓冲区中
								client.write(buffer);// 将字节序列从给定的缓冲区中写入此通道,并返回给客户端
							}
						}
						/*if (key.isValid() && key.isWritable()) {// 判断此键是否有效,并测试此键的通道是否已准备好进行写入
							SocketChannel client = (SocketChannel) key.channel();
							ByteBuffer output = (ByteBuffer) key.attachment();
							output.flip();// 反转此缓冲区
							client.write(output);
							output.compact();// 压缩此缓冲区
						}*/
					} catch (IOException ex) { // 出现异常时关闭
						key.cancel();
						try {
							key.channel().close();
						} catch (IOException cex) {
						}
					}
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}