package com.devil.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

import com.devil.utils.ConParams.HttpParams;
import com.google.common.base.Preconditions;

public class BaseHttpClient {
	/**
	 * 请求超时
	 */
	private Integer TIME_OUT = 111 * 1000;
	/**
	 * 读取超时
	 */
	private Integer SO_OUT = 111 * 1000;
	private Integer CONN_MANAGER_TIMEOUT = 111 * 1000;
	/**
	 * 字符编码 默认UTF-8
	 */
	private String CHARACTER_ENCODING = "UTF-8";
	/**
	 * 传输类型 默认application/x-www-form-urlencoded
	 */
	private String CONTENT_TYPE = "application/x-www-form-urlencoded";
	private CloseableHttpClient httpclient = null;
	protected Integer MAX_TOTAL = 500;// 并发最大连接数
	private CookieStore cookieStore;
	private PoolingHttpClientConnectionManager cm;

	public BaseHttpClient() {
		// TODO Auto-generated constructor stub
		cm = new PoolingHttpClientConnectionManager();
		cm.setMaxTotal(MAX_TOTAL);
		cookieStore = new BasicCookieStore();
		httpclient = HttpClients.custom().setConnectionManager(cm)
				.setDefaultCookieStore(cookieStore).build();
	}

	/**
	 * 
	 * @param url
	 * @param header
	 * @param data
	 * @param contentType
	 * @param noNeedResponse
	 * @param cookies
	 * @param method
	 * @return
	 * @throws Exception
	 * @throws HttpException
	 */
	String basedhttpClient(String url, Map<String, String> header, String data,
			ContentType contentType, List<BasicClientCookie> cookies, String method)
			throws Exception {
		if (cookies != null) {
			for (BasicClientCookie bcc : cookies)
				cookieStore.addCookie(bcc);
		}
		HttpUriRequest httpMethod = null;
		if (method.equals("post"))
			httpMethod = httpPost(url, header, data, contentType);
		else
			httpMethod = httpGet(url, header, data);

		CloseableHttpResponse httpResponse = null;
		try {
			httpResponse = httpclient.execute(httpMethod);
			Preconditions.checkArgument(
					httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK,
					httpResponse.getStatusLine().getStatusCode()
							+ "|"
							+ httpResponse.getStatusLine().getReasonPhrase());
			//System.out.println(IOUtils.toString(httpResponse.getEntity().getContent()));
			return EntityUtils.toString(httpResponse.getEntity(), contentType.getCharset().name());
		} catch (Exception e) {
			throw e;
		} finally {
			if (httpResponse != null)
				try {
					httpResponse.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			// 释放连接
			((HttpRequestBase) httpMethod).releaseConnection();
		}
	}

	/**
	 * post请求
	 * 
	 * @param url
	 * @param header
	 * @param data
	 * @param contentType
	 * @return
	 */
	HttpPost httpPost(String url, Map<String, String> header, String data, ContentType contentType) {
		// post请求返回结果
		HttpPost httpMethod = new HttpPost(url);
		RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.DEFAULT)
				.setSocketTimeout(TIME_OUT).setConnectTimeout(SO_OUT)
				.setConnectionRequestTimeout(CONN_MANAGER_TIMEOUT).build();// 设置请求和传输超时时间
		httpMethod.setConfig(requestConfig);
		if (header != null) {
			Iterator<Map.Entry<String, String>> entries = header.entrySet().iterator();
			while (entries.hasNext()) {
				Map.Entry<String, String> entry = entries.next();
				httpMethod.addHeader(entry.getKey(), entry.getValue());
			}
		}
		StringEntity stringEntity = new StringEntity(data, contentType);
		httpMethod.setEntity(stringEntity);
		return httpMethod;
	}

	/**
	 * get请求
	 * 
	 * @param url
	 * @param header
	 * @param data
	 * @return
	 */
	HttpGet httpGet(String url, Map<String, String> header, String data) {
		// post请求返回结果
		HttpGet httpMethod = new HttpGet(url + "?" + data);
		RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.DEFAULT)
				.setSocketTimeout(TIME_OUT).setConnectTimeout(SO_OUT)
				.setConnectionRequestTimeout(CONN_MANAGER_TIMEOUT).build();// 设置请求和传输超时时间
		httpMethod.setConfig(requestConfig);
		if (header != null) {
			Iterator<Map.Entry<String, String>> entries = header.entrySet().iterator();
			while (entries.hasNext()) {
				Map.Entry<String, String> entry = entries.next();
				httpMethod.addHeader(entry.getKey(), entry.getValue());
			}
		}

		return httpMethod;
	}

	/**
	 * 
	 * @param url
	 * @param header
	 * @param data
	 * @return
	 * @throws UnsupportedCharsetException
	 * @throws Exception
	 */
	public String httpClientPost(String url, Map<String, String> header, String data)
			throws Exception {

		return basedhttpClient(url, header, data,
				ContentType.create(CONTENT_TYPE, CHARACTER_ENCODING), null, "post");
	}

	/**
	 * 
	 * @param url
	 *            地址
	 * @param header
	 *            请求头
	 * @param data
	 *            请求参数
	 * @param contentType
	 *            请求内容类型
	 * @param noNeedResponse
	 *            是否返回内容
	 * @return
	 * @throws Exception
	 */
	public String httpClientPost(String url, Map<String, String> header, String data,
			ContentType contentType, boolean noNeedResponse) throws Exception {
		if (contentType.getCharset() != null)
			charset = contentType.getCharset();
		else
			charset = Charset.forName(CHARACTER_ENCODING);
		if (StringUtils.isBlank(contentType.getMimeType()))
			mimeType = contentType.getMimeType();
		return basedhttpClient(url, header, data, ContentType.create(mimeType, charset), null,
				"post");
	}

	/**
	 * 
	 * @param url
	 * @param header
	 * @param data
	 * @param contentType
	 * @param noNeedResponse
	 * @param cookies
	 * @return
	 * @throws Exception
	 */
	public String httpClientPost(String url, Map<String, String> header, String data,
			ContentType contentType, boolean noNeedResponse, List<BasicClientCookie> cookies)
			throws Exception {
		if (contentType.getCharset() != null)
			charset = contentType.getCharset();
		else
			charset = Charset.forName(CHARACTER_ENCODING);
		if (StringUtils.isBlank(contentType.getMimeType()))
			mimeType = contentType.getMimeType();
		return basedhttpClient(url, header, data, ContentType.create(mimeType, charset), cookies,
				"post");
	}

	/**
	 * 
	 * @param url
	 * @param header
	 * @param data
	 * @param character字符编码
	 * @param noNeedResponse
	 * @param cookies
	 * @return
	 * @throws UnsupportedCharsetException
	 * @throws Exception
	 */
	public String httpClientGet(String url, Map<String, String> header, String data,
			String character, boolean noNeedResponse, List<BasicClientCookie> cookies)
			throws Exception {
		if (StringUtils.isBlank(character))
			character = CHARACTER_ENCODING;
		return basedhttpClient(url, header, data, ContentType.create(CONTENT_TYPE, character),
				cookies, "get");
	}

	/**
	 * 
	 * @param url
	 * @param header
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public String httpClientGet(String url, Map<String, String> header, String data,
			String character, boolean noNeedResponse) throws Exception {
		if (StringUtils.isBlank(character))
			character = CHARACTER_ENCODING;
		return basedhttpClient(url, header, data,
				ContentType.create(CONTENT_TYPE, Charset.forName(CHARACTER_ENCODING)), null, "get");
	}

	/**
	 * 
	 * @param url
	 * @param header
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public String httpClientGet(String url, Map<String, String> header, String data)
			throws Exception {
		return basedhttpClient(url, header, data,
				ContentType.create(CONTENT_TYPE, Charset.forName(CHARACTER_ENCODING)), null, "get");
	}

	public String httpClientPost(String url, HttpEntity httpEntity, Map<String, String> header)
			throws Exception {
		HttpPost httpPost = new HttpPost(url);
		if (header != null) {
			Iterator<Map.Entry<String, String>> entries = header.entrySet().iterator();
			while (entries.hasNext()) {
				Map.Entry<String, String> entry = entries.next();
				httpPost.addHeader(entry.getKey(), entry.getValue());
			}
		}
		httpPost.setEntity(httpEntity);
		HttpResponse httpResponse = null;
		try {
			httpResponse = httpclient.execute(httpPost);
			Preconditions.checkArgument(
					httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK, httpResponse
							.getStatusLine().getStatusCode());
			return EntityUtils.toString(httpResponse.getEntity(), CHARACTER_ENCODING);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		} finally {
			// 释放连接
			httpPost.releaseConnection();
		}

	}

	String mimeType;
	Charset charset;

	/**
	 * 恢复默认值
	 */
	public final void restoreDefault() {
		TIME_OUT = HttpParams.TIME_OUT;
		SO_OUT = HttpParams.SO_OUT;
		CONN_MANAGER_TIMEOUT = HttpParams.CONN_MANAGER_TIMEOUT;
		CONTENT_TYPE = HttpParams.DEFUALT_CONTENT_TYPE;
		CHARACTER_ENCODING = HttpParams.DEFAULT_CHARACTER;
	}

	public final Integer getTIME_OUT() {
		return TIME_OUT;
	}

	public final void setTIME_OUT(Integer tIME_OUT) {
		TIME_OUT = tIME_OUT;
	}

	public final Integer getSO_OUT() {
		return SO_OUT;
	}

	public final void setSO_OUT(Integer sO_OUT) {
		SO_OUT = sO_OUT;
	}

	public final Integer getCONN_MANAGER_TIMEOUT() {
		return CONN_MANAGER_TIMEOUT;
	}

	public final void setCONN_MANAGER_TIMEOUT(Integer cONN_MANAGER_TIMEOUT) {
		CONN_MANAGER_TIMEOUT = cONN_MANAGER_TIMEOUT;
	}

	public final String getCHARACTER_ENCODING() {
		return CHARACTER_ENCODING;
	}

	public final void setCHARACTER_ENCODING(String cHARACTER_ENCODING) {
		CHARACTER_ENCODING = cHARACTER_ENCODING;
	}

	public final String getCONTENT_TYPE() {
		return CONTENT_TYPE;
	}

	public final void setCONTENT_TYPE(String cONTENT_TYPE) {
		CONTENT_TYPE = cONTENT_TYPE;
	}

	public final CookieStore getCookieStore() {
		return cookieStore;
	}
	
	class HttpException extends Exception {
		private static final long serialVersionUID = 1L;
		public static final int code = 101;
		public static final String message = "Http请求异常:";

		public HttpException(String e) {
			super(e);
		}

		@Override
		public String toString() {
			return this.getMessage()+"|"+message;
		}

	}

}
