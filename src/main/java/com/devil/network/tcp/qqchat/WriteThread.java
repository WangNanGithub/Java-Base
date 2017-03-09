package com.devil.network.tcp.qqchat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class WriteThread extends Thread {

	private Socket socket;

	public WriteThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		try (DataOutputStream writer = new DataOutputStream(socket.getOutputStream())) {
			while (true) {
				String msg = scanner.nextLine();
				writer.writeUTF(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
