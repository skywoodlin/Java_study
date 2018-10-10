package net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by xjlin on 2018/10/10.
 *
 * 需求： 客户端发送数据给服务端， 并读取服务端反馈的数据
 */
public class TCPClient2{
    public static void main(String[] args) throws IOException{
        System.out.println("客户端2启动---------------");

        //建立连接
        Socket socket = new Socket(InetAddress.getLocalHost(), 10004);

        //获取输出流
        OutputStream out = socket.getOutputStream();

        //通过输出流写数据
        out.write(("Tcp2来了-------------").getBytes());

        //获取socket的读取流， 读取服务端发回的数据
        InputStream in = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);

        String dataFromServer = new String(buf, 0, len);
        System.out.println(dataFromServer);

        //关闭连接, 关socket自动关闭输出流
        socket.close();
    }
}
