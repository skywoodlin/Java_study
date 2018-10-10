package net.upload;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by xjlin on 2018/10/10.
 * 实现上传文本客户端
 */
public class uploadTextClient{
    private static final String FILE_STR = "d:\\test\\data.txt";
    public static void main(String[] args) throws IOException{
        Socket s = new Socket(InetAddress.getLocalHost(), 10005);

        //1. 确定数据源， 本地文本文件
        BufferedReader bufr = new BufferedReader(new FileReader(FILE_STR));

        //2. 确定目的， socket输出流
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        String line = null;
        while((line = bufr.readLine()) != null) {
            out.println(line);
        }

        /**
         * 以下代码解决服务端不知道客户端结没结束得问题， 因为服务端一直等
         */
//        out.println("over"); //1. 发送一个结束字符串 容易重复
        //2.客户端一开始定一个时间戳，发送到服务端， 服务端结束时以这个时间戳作为结束， 肯定不会重复， 麻烦
        //3. 封装好的函数, 就用这个
        s.shutdownOutput();

        //3. 返回服务器返回的数据
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String lineIn = bufIn.readLine();
        System.out.println(lineIn);

        //4. 关闭
        bufr.close();
        s.close();
    }
}
