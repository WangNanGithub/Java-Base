package com.devil.network.inet;

import java.io.*;
import java.net.*;

public class Weblog {

	public static void main(String[] args) {
		String filename = "日志文件路径";
		/**
		 * 文件的每行内容如此格式:205.160.186.76 unknown - [17/Jun/2012:22:53:58 -0500]
		 */
		try (FileInputStream fin = new FileInputStream(filename);
				Reader in = new InputStreamReader(fin);
				BufferedReader bin = new BufferedReader(in);) {

			for (String entry = bin.readLine(); entry != null; entry = bin.readLine()) {
				// 分解IP地址
				int index = entry.indexOf(' ');
				String ip = entry.substring(0, index);
				String theRest = entry.substring(index);

				// 向DNS请求主机名并显示
				try {
					InetAddress address = InetAddress.getByName(ip);
					System.out.println(address.getHostName() + theRest);
				} catch (UnknownHostException ex) {
					System.err.println(entry);
				}
			}
		} catch (IOException ex) {
			System.out.println("Exception: " + ex);
		}
	}
}