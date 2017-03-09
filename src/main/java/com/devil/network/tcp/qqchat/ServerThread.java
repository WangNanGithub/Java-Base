package com.devil.network.tcp.qqchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Map;

public class ServerThread extends Thread {

	private DataInputStream reader;

	public ServerThread(DataInputStream reader) {
		this.reader = reader;
	}

	@Override
	public void run() {
		try {
			while (true) {
				String data = reader.readUTF();
				System.out.println(data);
				String[] ss = data.split(",");
				Integer id = Integer.valueOf(ss[0]);
				String msg = ss[1];

				Map<Integer, Socket> users = ChatServer.users;
				Socket toP = users.get(id);
				DataOutputStream writer = new DataOutputStream(toP.getOutputStream());
				writer.writeUTF(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
