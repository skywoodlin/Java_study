package net.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadPicClient {

    /**
     * @param args
     * @throws IOException
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("上传图片客户端开启......");
        //1,创建socket客户端。
        Socket s = new Socket("192.168.1.253",10006);

        File picFile = new File("1.jpg");

        FileInputStream fis = new FileInputStream(picFile);

        OutputStream out = s.getOutputStream();

        byte[] buf = new byte[1024];

        int len = 0;
        while((len=fis.read(buf))!=-1){
            out.write(buf,0,len);
        }
        //告诉服务端写完了。
        s.shutdownOutput();

        //读取服务端数据。
        InputStream in = s.getInputStream();
        byte[] bufIn = new byte[1024];
        int lenIn = in.read(bufIn);
        String str = new String(bufIn,0,lenIn);
        System.out.println(str);


        fis.close();
        s.close();
    }

}
