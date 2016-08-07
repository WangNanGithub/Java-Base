package com.devil.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestGet {
	public static void main(String[] args) throws Exception {
		String data = "?createAt='2016-3-1'";
		String urlStr = "http://localhost:8077/report/os" + data;
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true); // 可以发送数据
		conn.setDoInput(true); // 可以接收数据
		conn.setRequestMethod("GET"); // POST方法
		// 必须注意此处需要设置UserAgent，否则google会返回403
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.connect();
		// 写入的POST数据
		// OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
		// osw.write("q=中国&sl=auto&tl=en&tc=1");
		// osw.flush();
		// osw.close();
		// 读取响应数据
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String result = "";
		String s;
		// 循环数据，赋值给s
		while ((s = in.readLine()) != null){
			result += s;
		}
		System.out.println(result);
		
	}
}
