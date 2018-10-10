package net.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by xjlin on 2018/10/10.
 */
public class ChatTest{
    public static void main(String[] args) throws SocketException{
        /**
         * 通过udp协议， 完成一个聊天程序
         */
        DatagramSocket sender = new DatagramSocket(8888);
        DatagramSocket receiver = new DatagramSocket(10002);

        new Thread(new Sender(sender)).start();
        new Thread(new Receiver(receiver)).start();
    }
}


class Sender implements Runnable{
    private DatagramSocket ds;

    public Sender(DatagramSocket ds){
        super();
        this.ds = ds;
    }

    @Override
    public void run(){
        //1. 要发送的数据来自哪里？ 键盘输入
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        try{
            while((line = bufr.readLine()) != null){
                //2. 封装数据包
                byte[] buf = line.getBytes();
                DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 10002);

                ds.send(dp);

                if("over".equals(line)){
                    break;
                }
            }

            //3. 将数据包发送出去
            ds.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

class Receiver implements Runnable{
    private DatagramSocket ds;

    public Receiver(DatagramSocket ds){
        super();
        this.ds = ds;
    }

    @Override
    public void run(){
        while(true){
            byte[] buf = new byte[1024];

            DatagramPacket dp = new DatagramPacket(buf, buf.length);

            try{
                ds.receive(dp);
            }catch(IOException e) {
                e.printStackTrace();
            }

            String ip = dp.getAddress().getHostAddress();

            String data = new String(dp.getData(), 0, dp.getLength());

            if("over".equals(data)) {
                System.out.println(ip + ".....离开聊天室");
                break;
            }
            System.out.println((ip + ": " + data));

        }
    }
}
