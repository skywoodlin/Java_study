package com.xjlin.httpServer;


import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by xjlin on 2019/1/17.
 */
public class TcpClient {
    public static void main(String[] args) throws IOException{
        System.out.println("socket tcp 客户端启动-----------");
        Socket socket = new Socket("127.0.0.1", 6777);
        OutputStream os = socket.getOutputStream();
        os.write("我是一个兵".getBytes());

        socket.close();
    }
}
