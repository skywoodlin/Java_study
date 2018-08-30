package basic.io;

/**
 * Created by xjlin on 2018/8/27.
 */
//2:基本流加数组,复制"d:\test\test.chm"  66M  0.467  ssd
//e:\\test.mp4 1.66G  10.791s   机械  比用BufferedOutputStream 慢一丢丢
// ssd和机械效果差不多

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
public class Copy02{
    public static void main(String[] args) throws IOException{
        //记录程序开始时间
        long t1 = System.currentTimeMillis();
        //创建基本字节流对象
        FileInputStream in = new FileInputStream("e:\\test.mp4");
        FileOutputStream out = new FileOutputStream("e:\\test3.mp4");
        //定义数组存储读取到的数据
        byte[] b = new byte[1024];
        int i = -1;//读取到的字节个数
        while((i = in.read(b)) != -1){
            out.write(b,0,i);
            out.flush();
        }
        //关闭流
        in.close();
        out.close();
        //记录程序结束时间
        long t2 = System.currentTimeMillis();
        System.out.println("耗时:"+(t2-t1)/1000.0);//耗时:0.467
    }
}
