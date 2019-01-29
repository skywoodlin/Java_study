package NIO.mayiketang;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by xjlin on 2019/1/15.
 */
public class GatherAndScatter{
    public static void main(String[] args) throws IOException{
        Charset cs1=Charset.forName("utf-8");

        //随机访问
        RandomAccessFile raf = new RandomAccessFile("d:\\test\\1.txt", "rw");

        //获取通道
        FileChannel channel = raf.getChannel();

        ByteBuffer buffer1 = ByteBuffer.allocate(3);
        ByteBuffer buffer2 = ByteBuffer.allocate(1024);


        ByteBuffer[] bufs = {buffer1, buffer2};
        //分散读取
        channel.read(bufs);

        for(ByteBuffer byteBuffer: bufs) {
            //切换成读模式
            byteBuffer.flip();
        }

        System.out.println(new String(bufs[0].array(), 0 , bufs[0].limit(),cs1));
        System.out.println("*********************************************");
        System.out.println(new String(bufs[1].array(), 0 , bufs[1].limit(),cs1));
        System.out.println("-------------------聚集写入-------------------");

        //获取通道
        RandomAccessFile raf2 = new RandomAccessFile("d:\\test\\1_bak.txt", "rw");
        FileChannel channel2 = raf2.getChannel();
        channel2.write(bufs);

    }


    @Test
    public void test() {
        double a = 9.00;
        double b = 9.11;
        double c = 9.000;
        double d = 9.10;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
