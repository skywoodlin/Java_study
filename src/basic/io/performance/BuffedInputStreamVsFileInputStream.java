package basic.io.performance;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xjlin on 2018/10/9.
 * 验证两种stream的效率问题
 *
 * 结论：
 * 1. 在8k的数组的情况下， 反而是FilenIputStream快
 * 2. 在128btye缓冲区/数组的情况下， buffer要快得多
 */
public class BuffedInputStreamVsFileInputStream{
    private static final String FILENAME = "d:\\11@宝宝成长记录_2018.05.02.chm";
    private static final int length1 = 1024 * 8;
    private static final int length2 = 128;


    public static void main(String[] args) throws IOException{
        long l1 = readByBufferedInputStream(length1);
        long l2 = readByInputStream(length1);
        System.out.println("size: " + length1 + ": 通过BufferedInputStream读取用时：" + l1 + ";通过FileInputStream读取用时：" + l2);

        long l3 = readByBufferedInputStream(length2);
        long l4 = readByInputStream(length2);
        System.out.println("size: " + length2 +": 通过BufferedInputStream读取用时：" + l3 + ";通过FileInputStream读取用时：" + l4);
    }


    public static long readByInputStream(int length) throws IOException{
        InputStream in = new FileInputStream(FILENAME);
        byte[] b = new byte[length];
        int l = 0;
        long start = System.currentTimeMillis();
        while(in.read(b, 0, length) != -1){
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long readByBufferedInputStream(int length) throws IOException{
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(FILENAME));
        byte[] b = new byte[length];
        int l = 0;
        long start = System.currentTimeMillis();
        while(in.read(b, 0, length) != -1){
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}
