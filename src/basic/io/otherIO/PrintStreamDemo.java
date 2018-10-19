package basic.io.otherIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by xjlin on 2018/10/18.
 */
public class PrintStreamDemo{
    private static final String path = "d:\\test\\printStreamDemo.txt";
    public static void main(String[] args) throws IOException{
        System.out.println("hello");

        //相当于
//        PrintStream ps = System.out;
//        ps.println("hello");

        //演示方法使用
        // 目的定位文件
        PrintStream out = new PrintStream(path);

        //将数据打印到文件中
//        out.write(97);  //a

        //使用write方法， 写出一个字节！！！
        out.write(355); //c  对于stream的write方法， 一次性只写入一个字节， 如果输入了超过一个字节的，截取最低一个字节
        out.write("353".getBytes()); //353

        //使用print方法， 按照原样输出, 保证数值的表现形式
        out.print(97); //97

        out.close();
    }
}
