package net.URL;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by xjlin on 2018/10/18.
 * 使用URL对象
 */
public class URLDemo{
    public static void main(String[] args) throws IOException{
        String str_url = "http://127.0.0.1:8080/test/1.html?name=skywoodlin";

        URL url = new URL(str_url);
        System.out.println("getProtocol:" + url.getProtocol());
        System.out.println("getHost:" + url.getHost());
        System.out.println("getPort:" + url.getPort());
        System.out.println("getFile:" + url.getFile());
        System.out.println("getPath:" + url.getPath());
        System.out.println("getQuery:" + url.getQuery());

        //获取远程资源的连接对象
        URLConnection conn = url.openConnection();

        //看看conn到底是什么
        System.out.println(conn);

        //准备读取资源
        InputStream in = conn.getInputStream();

        /**
         * 或者用简写获取输入流
         * 实际底层就是
         * url.openConnection().getInputStream();
         */
        //InputStream in2 = url.openStream();

        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String str = new String(buf, 0, len);
        System.out.println(str);
    }
}
