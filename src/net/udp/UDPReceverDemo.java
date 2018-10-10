package net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by xjlin on 2018/10/10.
 */
public class UDPReceverDemo{
    public static void main(String[] args) throws IOException{
        System.out.println("UDP接收端启动。。。。");

        //1. 创建socket服务
        DatagramSocket ds = new DatagramSocket(63333);

        //2. 使用socket接收数据
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);

        ds.receive(dp); //阻塞式方法

        //3. 通过数据包对象解析收到的数据
        String ip = dp.getAddress().getHostAddress();
        int port = dp.getPort();
        String data = new String(dp.getData(), 0, dp.getLength());
        System.out.println(ip + ": " + port + "---" + data);

        //4. 关闭
        ds.close();
    }
}
