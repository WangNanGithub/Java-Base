package com.devil.network.tcp.qqchat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReadThread extends Thread {

	private Socket socket;

	public ReadThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try (DataInputStream reader = new DataInputStream(socket.getInputStream())) {
			while (true) {
				String data = reader.readUTF();
				System.out.println(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
