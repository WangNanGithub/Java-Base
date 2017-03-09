package com.devil.network.tcp.bio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// 服务器类
public class ChatServer {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(7456);
            System.out.println("服务器启动......");
            while (true) {
                Socket socket = server.accept();
                System.out.println("接到连接" + socket.getInetAddress());
                new Thread(new ServerThread(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ServerThread implements Runnable {
        private Socket socket;

        public ServerThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    // 读取来自客户端的信息
                    String accpet = in.readUTF();
                    System.out.println(accpet);
                    // 服务器端发给客户端
                    System.out.println("服务器:" + accpet);
                    out.writeUTF("服务器:" + accpet);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}