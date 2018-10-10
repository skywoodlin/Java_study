package basic.io.charstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xjlin on 2018/10/8.
 *
 * 本质：
 * 字符流 = 字节流 + 编码表（自动帮你编码了）
 */
public class InputStreamReaderDemo{
    private static final String FILE_STR = "d:\\test\\data.txt";

    public static void main(String[] args) throws IOException{
        /**
         * 通过字符流读取中文数据
         */
        readCNText();
    }

    private static void readCNText() throws IOException{
        //1. 操作字节流的字符流对象， 必须先有字节流
//        FileInputStream fis = null;
//        fis = ;

        //2. 建立字节向字符的桥梁
        InputStreamReader isr = new InputStreamReader(new FileInputStream(FILE_STR));
        int ch = isr.read();
        System.out.println((char) ch);
        int ch2 = isr.read();
        System.out.println((char) ch2);
        int ch3 = isr.read();
        System.out.println((char) ch3);

        isr.close();


    }
}
