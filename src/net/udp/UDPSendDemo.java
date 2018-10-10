package net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by xjlin on 2018/10/10.
 */
public class UDPSendDemo{
    public static void main(String[] args) throws IOException{
        /**
         * 需求： 建立一个udp的发送端
         *
         * 思路：
         * 1. 建立可以实现udp传输的socket服务
         * 2. 明确具体发送的数据
         * 3. 通过socket服务将具体的数据发送出去。
         * 4. 关闭服务
         *
         */
        System.out.println("UDP发送端启动。。。。。");

        //1. 创建udp服务
        DatagramSocket ds = new DatagramSocket();

        //2. 明确数据。
        String str = "udp来了";
        byte[] buf = str.getBytes();

        //3. 发送数据
        DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 63333);
        ds.send(dp);

        //4. 关闭
        ds.close();

    }
}
