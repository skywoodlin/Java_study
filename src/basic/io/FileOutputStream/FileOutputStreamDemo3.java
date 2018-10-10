package basic.io.FileOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xjlin on 2018/9/12.
 * 写入换行等符号要用系统相关的
 *
 */
public class FileOutputStreamDemo3{
    private static final String ROOT_DIR = "d:" + File.separator + "test"+ File.separator + "streamTest"+ File.separator;
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");


    public static void main(String[] args) throws IOException{
        File dir = new File(ROOT_DIR);
        if(!dir.exists() || !dir.isDirectory()) {
            dir.mkdirs();
        }

        //1. 创建输出流对象, 打开文件写到末尾
        FileOutputStream fos = new FileOutputStream(ROOT_DIR + "fos.txt", true);

        //2. 调用输出流的写功能
        //输出换行符
        fos.write(LINE_SEPARATOR.getBytes());
        String string = "abcde";
        byte[] buf = string.getBytes();
        fos.write(buf);

        fos.write("abcde".getBytes());

        //3. 是否资源， 一定要做
        fos.close();
    }
}
