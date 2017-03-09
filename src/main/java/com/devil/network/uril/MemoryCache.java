package com.devil.network.uril;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * 
 * @author ys
 * @date 2016年5月17日 上午10:33:22
 * @version 1.0.0
 *
 *          在请求时存储和获取缓存的值,java要求一次只能有一个URL缓存。要改变缓存，需使用ResponseCache.setDefault(new MemoryCache());
 *          此方法会设置同一个java虚拟机中运行的所有程序所使用的缓存
 */
public class MemoryCache extends ResponseCache {

	private final Map<URI, SimpleCacheResponse> responses = new ConcurrentHashMap<URI, SimpleCacheResponse>();
	private final int maxEntries;

	public MemoryCache() {
		this(100);
	}

	public MemoryCache(int maxEntries) {
		this.maxEntries = maxEntries;
	}

	@Override
	public CacheRequest put(URI uri, URLConnection conn) throws IOException {

		if (responses.size() >= maxEntries)
			return null;

		CacheControl control = new CacheControl(conn.getHeaderField("Cache-Control"));
		if (control.noStore()) {
			return null;
		} else if (!conn.getHeaderField(0).startsWith("GET ")) {
			// only cache GET
			return null;
		}

		SimpleCacheRequest request = new SimpleCacheRequest();
		SimpleCacheResponse response = new SimpleCacheResponse(request, conn, control);

		responses.put(uri, response);
		return request;
	}

	@Override
	public CacheResponse get(URI uri, String requestMethod,
			Map<String, List<String>> requestHeaders) throws IOException {

		if ("GET".equals(requestMethod)) {
			SimpleCacheResponse response = responses.get(uri);
			// check expiration date
			if (response != null && response.isExpired()) {
				responses.remove(response);
				response = null;
			}
			return response;
		} else {
			return null;
		}
	}
}