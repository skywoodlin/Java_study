package net.myserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by xjlin on 2018/10/18.
 * 模拟浏览器， 并获取服务器的反馈信息
 *
 * 可以连tomcat试试看
 * 也可以连本包底下的MyServer
 */
public class MyBrowser{
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("localhost", 9090);

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        out.println("GET /test/1.html HTTP/1.1");
        out.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        out.println("Host: localhost:9090");
        out.println("User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:60.0) Gecko/20100101 Firefox/60.0");
        out.println("Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        out.println("Accept-Encoding: gzip, deflate");
        out.println("Connection: close");
        out.println("");


        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];

        int len = in.read(buf);
        String str = new String(buf, 0, len);
        System.out.println(str);

        s.close();
    }
}
