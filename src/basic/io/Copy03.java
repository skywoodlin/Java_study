package basic.io;

/**
 * Created by xjlin on 2018/8/27.
 */
//3:高效流逐字节,复制"e:\test.mp4"  1.66G  69.367  机械
//3:高效流逐字节,复制"d:\test.mp4"  1.66G  67.037  ssd
//机械和ssd差不多
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class Copy03{
    public static void main(String[] args) throws IOException{
        //记录系统时间
        long t1 = System.currentTimeMillis();
        //创建高效字符流
//        BufferedInputStream bin = new BufferedInputStream(new FileInputStream("e:\\test.mp4"));
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream("d:\\test.mp4"));
//        BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("e:\\test2.mp4"));
        BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("d:\\test2.mp4"));
        //定义i为ASCII码值
        int i = -1;
        while((i = bin.read()) != -1){
            bout.write(i);
        }
        //关闭流
        bin.close();
        bout.close();
        //记录系统时间
        long t2 = System.currentTimeMillis();
        System.out.println("耗时:"+(t2-t1)/1000.0);//耗时:69.367
    }
}
