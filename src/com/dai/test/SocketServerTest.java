package com.dai.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTest {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8084);

            Socket socket = serverSocket.accept();

            System.out.println("socket.isConnected() = " + socket.isConnected());
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            char[] buffer = new char[1024];                //缓冲
            int len = 0;                                //每次读取的长度（正常情况下是1024，最后一次可能不是1024，如果传输结束，返回-1）
            StringBuilder sb = new StringBuilder();        //构建读取的消息
            while ((len = br.read(buffer)) != -1) {        //接收客户端的消息
                sb.append(new String(buffer, 0, len));
            }
            System.out.println("收到客户端消息：" + sb.toString());

//            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
