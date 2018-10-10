package basic.io.FileInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by xjlin on 2018/9/17.
 * 读取文件字节流
 */
public class FileInputStreamDemo{
    private static final String FILE_STR = "d:\\test\\data.txt";

    public static void main(String[] args) throws IOException{
        //保证对象文件的存在性
        File file = new File(FILE_STR);
        if(!file.exists()){
            throw new RuntimeException("要读取得文件不存在");
        }

        //创建文件字节读取流对象时， 必须明确与之关联的数据源
        FileInputStream fis = new FileInputStream(file);

        //调用读取流对象方法 read（）
        int ch;
        int i = 0;
        while((ch = fis.read()) != -1) {
            System.out.println("byte " + i++ + ": " + (char)ch);  //看一下读取得字节时什么， 注意换行符也会输出
        }

        //关闭资源
        fis.close();
    }

}
