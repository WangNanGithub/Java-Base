package com.devil.network.uril;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * 
 * @author ys
 * @date 2016年5月17日 上午10:28:03
 * @version 1.0.0
 *
 *          获取headers，日期等
 */
public class SimpleCacheResponse extends CacheResponse {

	private final Map<String, List<String>> headers;
	private final SimpleCacheRequest request;
	private final Date expires;
	private final CacheControl control;

	public SimpleCacheResponse(SimpleCacheRequest request, URLConnection uc, CacheControl control)
			throws IOException {

		this.request = request;
		this.control = control;
		this.expires = new Date(uc.getExpiration());
		this.headers = Collections.unmodifiableMap(uc.getHeaderFields());
	}

	@Override
	public InputStream getBody() {
		return new ByteArrayInputStream(request.getData());
	}

	@Override
	public Map<String, List<String>> getHeaders() throws IOException {
		return headers;
	}

	public CacheControl getControl() {
		return control;
	}

	public boolean isExpired() {
		Date now = new Date();
		if (control.getMaxAge().before(now))
			return true;
		else if (expires != null && control.getMaxAge() != null) {
			return expires.before(now);
		} else {
			return false;
		}
	}
}