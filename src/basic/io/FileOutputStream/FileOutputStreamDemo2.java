package basic.io.FileOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xjlin on 2018/9/12.
 * 测试FileOutputStream
 *
 * 续写文件的功能
 *
 * 注意点
 * 1. （重要）一旦new了一个FileOutputStream成功, 没有的话会创建一个新文件， 如果文件存在，
 * 不管之前的文件是否有内容， 都会被删掉创建一个新的同名文件。
 *
 * 2. 一定要记得释放资源
 *
 * 3. 一定要做异常处理， 见下一个程序IOExceptionDemo
 *
 *  * 4. 如果只是想打开文件写到文件末尾（不覆盖）， 初始化时要加一个参数
 *  （同1比较： fos = new FileOutputStream(rootDir + "fos2.txt"， true);）
 *
 *
 */
public class FileOutputStreamDemo2{
    private static final String rootDir = "d:" + File.separator + "test"+ File.separator + "streamTest"+ File.separator;

    public static void main(String[] args) throws IOException{
        File dir = new File(rootDir);
        if(!dir.exists() || !dir.isDirectory()) {
            dir.mkdirs();
        }

        //1. 创建输出流对象, 打开文件写到末尾
        FileOutputStream fos = new FileOutputStream(rootDir + "fos.txt", true);

        //2. 调用输出流的写功能
        String string = "abcde";
        byte[] buf = string.getBytes();
        fos.write(buf);

        fos.write("abcde".getBytes());

        //3. 是否资源， 一定要做
        fos.close();
    }
}
