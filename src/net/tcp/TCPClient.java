package net.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by xjlin on 2018/10/10.
 */
public class TCPClient{
    public static void main(String[] args) throws IOException{
        System.out.println("客户端启动---------------");

        //建立连接
        Socket socket = new Socket(InetAddress.getLocalHost(), 10003);

        //获取输出流
        OutputStream out = socket.getOutputStream();

        //通过输出流写数据
        out.write(("Tcp来了-------------").getBytes());

        //关闭连接, 关socket自动关闭输出流
        socket.close();
    }
}
