package com.devil.network.uril;

import java.io.*;
import java.net.*;

/**
 * 
 * @author ys
 * @date 2016年5月17日 上午9:14:11
 * @version 1.0.0
 *
 *          设置字符集来下载一个网页
 */
public class EncodingAwareSourceViewer {

	public static void main(String[] args) {
		try {
			// 设置编码
			String encoding = "ISO-8859-1";
			URL u = new URL("http://www.baidu.com");
			URLConnection uc = u.openConnection();
			String contentType = uc.getContentType();
			int encodingStart = contentType.indexOf("charset=");
			if (encodingStart != -1) {
				encoding = contentType.substring(encodingStart + 8);
			}
			InputStream in = new BufferedInputStream(uc.getInputStream());
			Reader r = new InputStreamReader(in, encoding);
			int c;
			while ((c = r.read()) != -1) {
				System.out.print((char) c);
			}
			r.close();
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}