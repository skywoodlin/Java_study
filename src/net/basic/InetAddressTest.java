package net.basic;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by xjlin on 2018/10/10.
 */
public class InetAddressTest{
    public static void main(String[] args) throws UnknownHostException{
        InetAddress addr = Inet4Address.getLocalHost();
        System.out.println(addr.getAddress()); //对象地址
        System.out.println(addr.getHostAddress()); //192.168.42.115
        System.out.println(addr.getHostName());//skywoodlin
        System.out.println(addr.getCanonicalHostName()); //skywoodlin

        InetAddress addr2 = InetAddress.getLocalHost();
        System.out.println(addr2); //skywoodlin/192.168.42.115


        //获取其它域名的ip
        InetAddress addr3 = InetAddress.getByName("www.sohu.com");
        System.out.println(addr3); //www.sohu.com/120.204.199.140


        //获取一个域名的多个地址
        InetAddress[] addr4 = InetAddress.getAllByName("www.baidu.com");
        for(InetAddress tmp : addr4) {
            System.out.println(tmp);
        }

    }
}
