package com.devil.network.tcp.nio2;

import java.nio.*;
import java.nio.channels.*;
import java.net.*;
import java.util.*;
import java.io.IOException;

/**
 * 
 * @author ys
 * @date 2016年5月18日 下午4:52:11
 * @version 1.0.0
 *
 *          一个非阻塞的服务器
 */
public class ChargenServer {

	public static int DEFAULT_PORT = 7456;

	public static void main(String[] args) {

		int port = DEFAULT_PORT;
		System.out.println("监听端口:" + port);

		byte[] rotation = new byte[95 * 2];
		for (byte i = ' '; i <= '~'; i++) {
			rotation[i - ' '] = i;
			rotation[i + 95 - ' '] = i;
		}

		ServerSocketChannel serverChannel;
		Selector selector;
		try {
			serverChannel = ServerSocketChannel.open();
			ServerSocket ss = serverChannel.socket();
			InetSocketAddress address = new InetSocketAddress(port);
			ss.bind(address);
			serverChannel.configureBlocking(false);// 设置通道为非阻塞模式
			selector = Selector.open();
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException ex) {
			ex.printStackTrace();
			return;
		}

		while (true) {
			try {
				selector.select();
			} catch (IOException ex) {
				ex.printStackTrace();
				break;
			}

			Set<SelectionKey> readyKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = readyKeys.iterator();
			while (iterator.hasNext()) {

				SelectionKey key = iterator.next();
				iterator.remove();
				try {
					if (key.isAcceptable()) {
						ServerSocketChannel server = (ServerSocketChannel) key.channel();
						SocketChannel client = server.accept();
						System.out.println("Accepted connection from " + client);
						client.configureBlocking(false);
						SelectionKey key2 = client.register(selector, SelectionKey.OP_WRITE);
						ByteBuffer buffer = ByteBuffer.allocate(74);
						buffer.put(rotation, 0, 72);
						buffer.put((byte) '\r');
						buffer.put((byte) '\n');
						buffer.flip();
						key2.attach(buffer);
					} else if (key.isWritable()) {
						SocketChannel client = (SocketChannel) key.channel();
						ByteBuffer buffer = (ByteBuffer) key.attachment(); // 创建缓冲区
						/**
						 * 视图缓冲区
						 */
						// buffer.asCharBuffer();
						// buffer.asDoubleBuffer();
						// buffer.asFloatBuffer();
						/**
						 * 压缩缓冲区
						 */
						// buffer.compact();
						/**
						 * 赋值缓冲区
						 */
						// buffer.duplicate();
						if (!buffer.hasRemaining()) {
							// 用下一行重新填充缓冲区
							buffer.rewind();
							// 获得上一次的首字符
							int first = buffer.get();
							// 准备改变缓冲区中的数据
							buffer.rewind();
							// 寻找rotation中新的首字符位置
							int position = first - ' ' + 1;
							// 将数据从rotation赋值到缓冲区
							buffer.put(rotation, position, 72);
							// 在缓冲区末尾存储一个行分隔符
							buffer.put((byte) '\r');
							buffer.put((byte) '\n');
							// 准备缓冲区进行写入
							buffer.flip();
						}
						client.write(buffer);
					}
				} catch (IOException ex) {
					key.cancel();
					try {
						key.channel().close();
					} catch (IOException cex) {
					}
				}
			}
		}
	}
}