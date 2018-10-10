package basic.io.encode;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xjlin on 2018/9/17.
 */
public class ReadCNDemo{
    private static final int DEFAULT_SIZE = 1024;  //默认4k
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");


    public static void main(String[] args){
        //抓取开始时间
        long t1 = System.currentTimeMillis();
        BufferedInputStream bin = null;
        BufferedOutputStream bout = null;

        //创建高效流
        try{
            bin = new BufferedInputStream(new FileInputStream("d:" + FILE_SEPARATOR + "test" + FILE_SEPARATOR + "data.txt"));
            bout = new BufferedOutputStream(new FileOutputStream("d:" + FILE_SEPARATOR + "test" + FILE_SEPARATOR + "data2.txt"));

            //定义字节数组存储读取内容
            byte[] b = new byte[DEFAULT_SIZE];
            int i = -1;//读取到的字节个数
            while((i = bin.read(b)) != -1){
//                bout.write(b, 0, i);
//                bout.flush();
//                String a = new String(b, 0, i);
//                String c = new String(b, 0, i);
                String c = new String(b, 0, i, "UTF-8"); //主要是这一句
                System.out.println(c);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(bin != null){
                    bin.close();
                }
                if(bout != null){
                    bout.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }


        //抓取程序结束时间
        long t2 = System.currentTimeMillis();
        System.out.println("耗时:" + (t2 - t1) / 1000.0);//耗时: 0.405
    }
}
