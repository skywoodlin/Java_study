package NIO.FromWeb;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by xjlin on 2019/1/14.
 */
public class ChannelTest1{
    public static void main(String[] args){
        useNio();
    }
    private static void useNio(){
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("D:\\test\\1.txt", "rw");
            FileChannel inChannel = aFile.getChannel();

            //创建容量为48byte的buffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            int byteReader = inChannel.read(byteBuffer);//读取数据，放入buffer

            while (byteReader != -1) {
                System.out.println("Read:" + byteReader);
                byteBuffer.flip(); //设置buffer切换模式为读模式

                while (byteBuffer.hasRemaining()) {
                    System.out.println((char)byteBuffer.get()); // 每次读取1byte，也就是一个字节
                }

                byteBuffer.clear();//清空buffer，准备再次写入

                byteReader = inChannel.read(byteBuffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                aFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
