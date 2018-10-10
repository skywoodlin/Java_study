package net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xjlin on 2018/10/10.
 */
public class TCPServer2{
    public static void main(String[] args) throws IOException{
        System.out.println("服务器端2启动-------------");

        //1. 创建服务器端对象
        ServerSocket server = new ServerSocket(10004);

        //2. 获取客户端对象
        Socket client = server.accept();
        String clientIp = client.getInetAddress().getHostAddress();
        System.out.println(clientIp + "......connected");

        //3. 通过客户端对象获取socket流的读取流
        InputStream in = client.getInputStream();

        //
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String data = new String(buf, 0, len);
        System.out.println(data);

        //4. 给客户端返回数据
        OutputStream out = client.getOutputStream();
        out.write(("服务端2的返回数据").getBytes());

        client.close();
        server.close();
    }
}
