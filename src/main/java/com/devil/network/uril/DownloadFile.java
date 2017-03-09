package com.devil.network.uril;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 
 * @author ys
 * @date 2016年5月17日 上午9:22:04
 * @version 1.0.0
 *
 *          从网站下载二进制文件并保存
 */
public class DownloadFile {

	public static void main(String[] args) throws IOException {
		URL root = new URL("http://g.hiphotos.baidu.com/baike/w%3D268%3Bg%3D0/sign=fb7b656d4c540923aa696478aa63b634/f3d3572c11dfa9ecfcd9cd5967d0f703908fc18d.jpg");
		saveBinaryFile(root);
	}

	public static void saveBinaryFile(URL u) throws IOException {
		URLConnection uc = u.openConnection();
		/**
		 * 遍历所有头信息
		 */
		System.out.println("==================");
		Map<String, List<String>> header = uc.getHeaderFields();
		Set<Entry<String, List<String>>> set = header.entrySet();
		for (Entry<String, List<String>> entry : set) {
			System.out.println(entry.getKey() + ":" + entry.getValue().toString());
		}
		String contentType = uc.getContentType();
		int contentLength = uc.getContentLength();
		if (contentType.startsWith("text/") || contentLength == -1) {
			throw new IOException("这不是一个二进制文件");
		}
		try (InputStream raw = uc.getInputStream()) {
			InputStream in = new BufferedInputStream(raw);
			byte[] data = new byte[contentLength];
			int offset = 0;
			while (offset < contentLength) {
				int bytesRead = in.read(data, offset, data.length - offset);
				if (bytesRead == -1)
					break;
				offset += bytesRead;
			}
			if (offset != contentLength) {
				throw new IOException("只读了" + offset + "bytes;预期为" + contentLength + "bytes");
			}
			String filename = u.getFile();
			System.out.println(contentLength);
			System.out.println(filename);
			filename = filename.substring(filename.lastIndexOf('/') + 1);
			System.out.println(filename);
			try (FileOutputStream fout = new FileOutputStream("D:/" + filename)) {
				fout.write(data);
				fout.flush();
			}
		}
	}
}
