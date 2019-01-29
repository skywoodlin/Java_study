package com.xjlin.httpServer;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xjlin on 2019/1/17.
 */
public class TcpServer{
    public static void main(String[] args) throws IOException{
        System.out.println("socket tcp服务器启动------");

        //拿到缓存的线程池
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ServerSocket ss = new ServerSocket(6777);

        try{
            while(true){
                Socket accept = ss.accept();
                newCachedThreadPool.execute(new Runnable(){
                    @Override
                    public void run(){
                        try{
                            InputStream is = accept.getInputStream();
                            byte[] buf = new byte[1024];
                            int len = is.read(buf);
                            String string = new String(buf, 0, len);
                            System.out.println("服务器接收客服端内容： " + string);
                        }catch(IOException e){
                            e.printStackTrace();
                        }
                    }
                });

            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ss.close();
        }

    }
}


