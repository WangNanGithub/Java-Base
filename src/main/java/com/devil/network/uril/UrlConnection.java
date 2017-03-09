package com.devil.network.uril;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * @author ys
 * @date 2016年5月17日 上午8:54:46
 * @version 1.0.0
 *
 *          建立连接，并获取返回数据
 */
public class UrlConnection {
	public static void main(String[] args) throws IOException {
		URL u = new URL("http://www.baidu.com"); // URL
		URLConnection uc = u.openConnection(); // 建立连接
		try (InputStream in = uc.getInputStream();) {
			InputStream buffer = new BufferedInputStream(in);
			Reader reader = new InputStreamReader(buffer);
			int c;
			while ((c = reader.read()) != -1) {
				System.out.print((char) c); // 这部分就是html的数据，可以新建一个html，就是百度首页
			}
			/**
			 * 首部字段相关信息(部分)
			 */
			System.out.println(uc.getContentEncoding()); // WEB服务器表明自己使用了什么压缩方法
			System.out.println(uc.getContentType()); // 数据及编码类型
			System.out.println(uc.getContentLength());// WEB服务器告诉浏览器自己响应的对象的长度,如果没有Content-Length首部则返回-1
			System.out.println(uc.getContentLengthLong());// 同上，但是类型为long可以处理更大资源
			System.out.println(uc.getDate());// 日期
			System.out.println(uc.getLastModified());// WEB服务器认为对象的最后修改时间,没有就返回0
			System.out.println(uc.getExpiration()); // WEB服务器表明该实体将在什么时候过期，对于过期了的对象，只有在跟WEB服务器验证了其有效性后，才能用来响应客户请求
			/**
			 * 遍历所有头信息
			 */
			System.out.println("==================");
			Map<String, List<String>> header = uc.getHeaderFields();
			Set<Entry<String, List<String>>> set = header.entrySet();
			for (Entry<String, List<String>> entry : set) {
				System.out.println(entry.getKey() + ":" + entry.getValue().toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
