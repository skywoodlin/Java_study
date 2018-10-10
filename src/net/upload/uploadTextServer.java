package net.upload;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xjlin on 2018/10/10.
 * 实现上传文本
 */
public class uploadTextServer{
    private static final String FILE_STR = "d:\\test\\dataUpload.txt";

    public static void main(String[] args) throws IOException {

        /*
         * 上传文本的服务端。接收文本数据，并存储到文件中，服务端接收完毕后，回馈"上传成功"字样。
         */
        System.out.println("上传文本服务器端启动.......");
        //1,服务端对象。
        ServerSocket ss = new ServerSocket(10005);

        //2,获取客户端。
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip+".....connected");

        //3,获取读取流。确定源，网络socket。
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

        //4,确定目的。文件。
        PrintWriter pw = new PrintWriter(new FileWriter(FILE_STR),true);

        //5,频繁读写。
        String line = null;
        while((line=bufIn.readLine())!=null){
//            if("over".equals(line)) {
//                break;
//            }
            pw.println(line);
        }

        //6,给客户端返回信息。
        PrintWriter out = new PrintWriter(s.getOutputStream(),true);
        out.println("上传成功");

        pw.close();
        s.close();
        ss.close();
    }
}
