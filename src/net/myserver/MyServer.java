package net.myserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xjlin on 2018/10/18.
 * 模拟tomcat服务器， 获取浏览器信息
 */
public class MyServer{
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(9090);

        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostName() + "......connected");

        InputStream in = s.getInputStream();

        byte[] buf = new byte[1024];

        int len = in.read(buf);
        String str = new String(buf, 0,len);
        System.out.println(str);

        //给浏览器一个回馈
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println("<font size = '7' color = 'green'>欢迎光临， 您访问的是自定义服务器！</font>");

        s.close();
        ss.close();
    }
}
