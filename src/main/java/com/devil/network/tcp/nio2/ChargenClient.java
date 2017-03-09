package com.devil.network.tcp.nio2;

import java.nio.*;
import java.nio.channels.*;
import java.net.*;
import java.io.IOException;

/**
 * 
 * @author ys
 * @date 2016年5月18日 下午4:49:14
 * @version 1.0.0
 *
 *          一个基于通道的客户端
 */
public class ChargenClient {

	public static int DEFAULT_PORT = 7456;

	public static void main(String[] args) {

		int port = DEFAULT_PORT;

		try {
			SocketAddress address = new InetSocketAddress("localhost", port);
			SocketChannel client = SocketChannel.open(address);

			ByteBuffer buffer = ByteBuffer.allocate(74);
			WritableByteChannel out = Channels.newChannel(System.out);

			while (client.read(buffer) != -1) {
				buffer.flip();
				out.write(buffer);
				buffer.clear();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}