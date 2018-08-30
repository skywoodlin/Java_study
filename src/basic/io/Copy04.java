package basic.io;

/**
 * Created by xjlin on 2018/8/27.
 */
//4:基本流逐字节复制, 复制"d:\test.mp4"  285m 10几分钟还没完成  ssd

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class Copy04{
    public  static void main(String[] args) throws IOException{
        //记录系统时间
        long t1 = System.currentTimeMillis();
        //创建基本字节流对象
        FileInputStream in = new FileInputStream("d:\\test.mp4");
        FileOutputStream out = new FileOutputStream("d:\\test2.mp4");
        //定义不在ASCII码值范围内的i
        int i = -1;
        while((i = in.read()) != -1){
            out.write(i);
            out.flush();
        }
        //关闭流
        out.close();
        in.close();
        //记录系统时间
        long t2 = System.currentTimeMillis();
        System.out.println("耗时:"+(t2-t1)/1000.0);//耗时:52.383
    }
}