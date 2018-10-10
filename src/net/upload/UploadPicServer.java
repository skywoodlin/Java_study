package net.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadPicServer {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println("上传图片服务端开启......");
        ServerSocket ss = new ServerSocket(10006);
        while(true){
            //服务端对象。

            Socket s = ss.accept();

            new Thread(new UploadPic(s)).start();

        }
//		ss.close();

    }



}
