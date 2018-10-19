package basic.io.otherIO;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by xjlin on 2018/10/19.
 */
public class RandomAccessFileDemo{

    private static final String path = "d:\\test\\RandomAccessFileDemo.txt";

    public static void main(String[] args) throws IOException{
        /*
         * RandomAccessFile:
         * 特点：
         * 1，只能操作文件。
         * 2，既能读，又能写。
         * 3，维护了一个byte数组。内部定义了字节流的读取和写入。
         * 4，通过对指针的操作可以实现对文件的任意位置的读取和写入。
         */
//        writeFile();

        readFile();
    }

    public static void readFile() throws IOException{

        RandomAccessFile raf = new RandomAccessFile(path, "r");

        //随机读取，只要通过设置指针的位置即可。
        raf.seek(8*1);

        byte[] buf = new byte[4];
        raf.read(buf);
        String name = new String(buf);

        int age = raf.readInt();

        System.out.println(name+":"+age);

        raf.close();



    }

    public static void writeFile() throws IOException {

        //1，创建一个随机访问文件的对象。文件不存在，则创建，存在，则不创建不覆盖。
        RandomAccessFile raf = new RandomAccessFile(path, "rw");

        //2，写入姓名和年龄。
//		raf.write("张三".getBytes());
//		raf.writeInt(97);//保证整数的字节原样性。
//		raf.write("李四".getBytes());
//		raf.writeInt(99);//保证整数的字节原样性。

        //3,随机写入。
        raf.seek(8);//设置指针的位置。
        raf.write("王武".getBytes());
        raf.writeInt(100);
        System.out.println(raf.getFilePointer());

        raf.close();


    }
}
