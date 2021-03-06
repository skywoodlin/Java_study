package basic.io;

//标准写法， 以后参照这个


//1:高效流加数组,复制"d:\\test\\test.chm"  66M  0.405s  ssd
// e:\\test.mp4 1.66G  9.549s   机械
// ssd和机械效果差不多

//注意2： BufferedInputStream，BufferedOutputStream到底缓存多少字节呢？ 答案是8192， 看源码就知道


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy01{
    private static final int DEFAULT_SIZE = 1024 * 4;  //默认4k
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");

    public static void main(String[] args){
        //抓取开始时间
        long t1 = System.currentTimeMillis();
        BufferedInputStream bin = null;
        BufferedOutputStream bout = null;

        //创建高效流
        try{
            bin = new BufferedInputStream(new FileInputStream("N: " + FILE_SEPARATOR + "迅雷下载" + FILE_SEPARATOR + "STAR-972.mp4"));
            bout = new BufferedOutputStream(new FileOutputStream("N: " + FILE_SEPARATOR + "迅雷下载" + FILE_SEPARATOR + "STAR-972_2" +
                    ".mp4"));

            //定义字节数组存储读取内容
            byte[] b = new byte[DEFAULT_SIZE];
            int i = -1;//读取到的字节个数
            while((i = bin.read(b)) != -1){
                bout.write(b, 0, i);
                bout.flush();
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
