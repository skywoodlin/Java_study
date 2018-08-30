package basic.io;

//1:高效流加数组,复制"d:\\test\\test.chm"  66M  0.405s  ssd
// e:\\test.mp4 1.66G  9.549s   机械
// ssd和机械效果差不多

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class Copy01{
    public static void main(String[] args) throws IOException{
        //抓取开始时间
        long t1 = System.currentTimeMillis();
        //创建高效流
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream("e:\\test.mp4"));
        BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("e:\\test2.mp4"));
        //定义字节数组存储读取内容
        byte[] b = new byte[1024];
        int i = -1;//读取到的字节个数
        while((i = bin.read(b)) != -1){
            bout.write(b,0,i);
            bout.flush();
        }
        bout.close();
        bin.close();
        //抓取程序结束时间
        long t2 = System.currentTimeMillis();
        System.out.println("耗时:"+(t2-t1)/1000.0);//耗时: 0.405
    }
}
