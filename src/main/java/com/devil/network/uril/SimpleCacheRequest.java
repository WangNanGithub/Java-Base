package com.devil.network.uril;

import java.io.*;
import java.net.*;

/**
 * 
 * @author ys
 * @date 2016年5月17日 上午10:26:38
 * @version 1.0.0
 *
 *          实现CacheRequest，URL将把读取的可缓存数据写入这个输入流
 */
public class SimpleCacheRequest extends CacheRequest {

	private ByteArrayOutputStream out = new ByteArrayOutputStream();

	@Override
	public OutputStream getBody() throws IOException {
		return out;
	}

	@Override
	public void abort() {
		out.reset();
	}

	public byte[] getData() {
		if (out.size() == 0)
			return null;
		else
			return out.toByteArray();
	}
}