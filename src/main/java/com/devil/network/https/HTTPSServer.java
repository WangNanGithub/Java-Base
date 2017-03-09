package com.devil.network.https;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyStore;
import java.util.Arrays;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class HTTPSServer {
	public final static int PORT = 7456;
	public final static String algorithm = "SSL";

	public static void main(String[] args) {
		try {
			SSLContext context = SSLContext.getInstance(algorithm);

			// 只支持 X.509 密钥
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");

			// Oracle的默认密钥库类型
			KeyStore ks = KeyStore.getInstance("JKS");

			// 处于安全考虑，每个密钥库都必须用口令短语加密
			// 在从磁盘加载前必须提供这个口令
			// 口令短语以char[]数组形式存储，所以可以很快从内存中擦除，而不是等待垃圾回收
			char[] password = { 'p', 'r', 'o', 'p', 'r', 'o' };// 这里的密码和jnp4e.keys中报存的一致
			// Console console = System.console();
			// password = console.readPassword();//这种方法需要在cmd中输入
			ks.load(new FileInputStream(
					"C:/Users/abc/Desktop/Java-Network/src/com/devil/network/https/jnp4e.keys"),
					password);
			kmf.init(ks, password);
			context.init(kmf.getKeyManagers(), null, null);

			// 擦除口令
			Arrays.fill(password, '0');

			SSLServerSocketFactory factory = context.getServerSocketFactory();

			SSLServerSocket server = (SSLServerSocket) factory.createServerSocket(PORT);

			// 添加匿名（未认证）密码组
			String[] supported = server.getSupportedCipherSuites();
			String[] anonCipherSuitesSupported = new String[supported.length];
			int numAnonCipherSuitesSupported = 0;
			for (int i = 0; i < supported.length; i++) {
				if (supported[i].indexOf("_anon_") > 0) {
					anonCipherSuitesSupported[numAnonCipherSuitesSupported++] = supported[i];
				}
			}

			String[] oldEnabled = server.getEnabledCipherSuites();
			String[] newEnabled = new String[oldEnabled.length + numAnonCipherSuitesSupported];
			System.arraycopy(oldEnabled, 0, newEnabled, 0, oldEnabled.length);
			System.arraycopy(anonCipherSuitesSupported, 0, newEnabled, oldEnabled.length,
					numAnonCipherSuitesSupported);

			server.setEnabledCipherSuites(newEnabled);
			System.out.println("准备完成，开始通讯...");
			while (true) {
				try (Socket theConnection = server.accept()) {
					InputStream in = theConnection.getInputStream();
					int c;
					while ((c = in.read()) != -1) {
						System.out.write(c);
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
