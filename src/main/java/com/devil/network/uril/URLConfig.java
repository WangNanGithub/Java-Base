package com.devil.network.uril;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 
 * @author ys
 * @date 2016年5月17日 上午10:49:08
 * @version 1.0.0
 *
 *          配置属性,模拟向服务器发送数据
 */
public class URLConfig {
	/**
	 * URLConnection有7个保护(protected)的实例字段，定义客户端如何向服务器做出请求，可通过set和get方式设置
	 */
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://localhost:8080/ping/netpost");
		URLConnection connection = url.openConnection();
		configConnection(connection);
		configHeaders(connection);
		configData(connection);

		Map<String, List<String>> header = connection.getHeaderFields();
		Set<Entry<String, List<String>>> set = header.entrySet();
		for (Entry<String, List<String>> entry : set) {
			System.out.println(entry.getKey() + ":" + entry.getValue().toString());
		}
		System.out.println("ok");
	}

	/**
	 * 配置连接
	 * 
	 * @param connection
	 */
	public static void configConnection(URLConnection connection) {
		// 1.connect表示连接状态，连接打开为true，连接关闭为false(没有直接读取或改变其值的方法)
		// 创建一个URLConnection时连接未打开，初始值为false
		// connect()、getinputstream、getoutputstream等都可以打开连接

		// 2.allowUserInteraction表示是否允许用户交互,允许交互为true，不允许交互为false
		// 例如：浏览器可能需要用户名和口令
		// connection.setAllowUserInteraction(true);

		// 3.doInput，如果URLConnection可以用来读取，则值为true否则为false（默认true）
		// connection.setDoInput(false);

		// 4.doOutput,设置这个来发送数据
		// 如果设置为true，则请求从GET改为POST
		connection.setDoOutput(true);

		// 5.ifModifiedSince,设置一个时间，如果对应文档在时间之后有修改，服务器会发送新的文档,用于更新本地缓存
		// connection.setIfModifiedSince(0);

		// 6.useCaches 设置是否使用缓存 false表示没有缓存,确保每次获取最新版本
		// connection.setUseCaches(false);

		// 7.超时时间
		// connection.setConnectTimeout(10000); // 10秒超时
		// connection.setReadTimeout(0); // 0表示永不超时
	}

	/**
	 * 配置HTTP首部
	 * 
	 * @param connection
	 */
	public static void configHeaders(URLConnection connection) {
		// connection.setRequestProperty("Cookie", "username=aaa;password=adsa;session=100556");//
		// set会覆盖相同的key
		// connection.addRequestProperty("", "");// add可以添加相同的key
		connection.setRequestProperty("Content-Type", "application/json");
	}

	/**
	 * 配置向服务器写入的数据
	 * 
	 * @param connection
	 * @throws IOException
	 */
	public static void configData(URLConnection connection) throws IOException {
		OutputStream raw = connection.getOutputStream();
		OutputStream buffered = new BufferedOutputStream(raw);
		OutputStreamWriter out = new OutputStreamWriter(buffered, "UTF-8");
		out.write("{name:'123',id:12}");
		out.flush();
		out.close();
	}
}
