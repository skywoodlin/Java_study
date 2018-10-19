package net.URL;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by xjlin on 2018/10/18.
 *
 * 测试各种读取网络资源的方法
 */
public class TestURL{
    public static void main(String[] args) throws IOException{
        test4();
        test3();
        test2();
        test();
    }

    /**
     * 获取URL指定的资源。
     *
     * @throws IOException
     */
    public static void test4() throws IOException{
        URL url = new URL("http://lavasoft.blog.51cto.com/attachment/200811/200811271227767778082.jpg");
        //获得此URL的内容。
        Object obj = url.getContent();
        System.out.println(obj.getClass().getName());
    }

    /**
     * 获取URL指定的资源
     *
     * @throws IOException
     */
    public static void test3() throws IOException{
        System.out.println("in test3");
//        http://127.0.0.1:8080/test/1.html?name=skywoodlin

        String str_url = "http://localhost:8080/test/1.html?name=skywoodlin";

        URL url = new URL(str_url);
        //返回一个URLConnection对象，它表示到URL所引用的远程对象的连接。
        URLConnection uc = url.openConnection();
        System.out.println(uc);
        //打开的连接读取的输入流。
        InputStream in = uc.getInputStream();

        int c;
        while((c = in.read()) != -1) {
            System.out.print(c);
        }
        in.close();
    }

    /**
     * 读取URL指定的网页内容
     *
     * @throws IOException
     */
    public static void test2() throws IOException{
        System.out.println("in test2");

        URL url = new URL("http://localhost:8080/test/1.html");
        //打开到此URL的连接并返回一个用于从该连接读入的InputStream。
        Reader reader = new InputStreamReader(new BufferedInputStream(url.openStream()));
        int c;
        while((c = reader.read()) != -1){
            System.out.print((char) c);
        }
        reader.close();
    }

    /**
     * 获取URL的输入流，并输出
     *
     * @throws IOException
     */
    public static void test() throws IOException{
        URL url = new URL("http://lavasoft.blog.51cto.com/62575/120430");
        //打开到此URL的连接并返回一个用于从该连接读入的InputStream。
        InputStream in = url.openStream();
        int c;
        while((c = in.read()) != -1)
            System.out.print(c);
        in.close();
    }
}
