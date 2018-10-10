package basic.io.FileOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xjlin on 2018/9/12.
 * 测试FileOutputStream
 *
 * 注意点
 * 1. （重要）一旦new了一个FileOutputStream成功, 没有的话会创建一个新文件， 如果文件存在，
 * 不管之前的文件是否有内容， 都会被删掉创建一个新的同名文件。
 *
 * 2. 一定要记得释放资源
 *
 * 3. 一定要做异常处理， 见下一个程序IOExceptionDemo
 *
 *
 */
public class FileOutputStreamDemo{
    private static final String rootDir = "d:" + File.separator + "test"+ File.separator + "streamTest"+ File.separator;

    public static void main(String[] args) throws IOException{
        File dir = new File(rootDir);
        if(!dir.exists() || !dir.isDirectory()) {
            dir.mkdirs();
        }

        //1. 创建输出流对象
        FileOutputStream fos = new FileOutputStream(rootDir + "fos.txt");

        //2. 调用输出流的写功能
        String string = "abcde";
        byte[] buf = string.getBytes();
        fos.write(buf);

        fos.write("abcde".getBytes());

        //3. 是否资源， 一定要做
        fos.close();
    }
}
