package basic.io.charstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xjlin on 2018/10/8.
 */
public class InputStreamReaderDemo2{
    private static final String FILE_STR = "d:\\test\\data.txt";

    public static void main(String[] args) throws IOException{
        /**
         * 通过字符流读取中文数据
         */
        readCNText();
    }

    private static void readCNText() throws IOException{
        //1. 操作字节流的字符流对象， 必须先有字节流
////        FileInputStream fis = null;
////        fis = ;
//
//        //2. 建立字节向字符的桥梁
//        try(
//                InputStreamReader isr = new InputStreamReader(new FileInputStream(FILE_STR))
//        ){
//            //定义字节数组存储读取内容
//            char[] c = new char[1024];
//            int i = -1;//读取到的字节个数
//            while((i = isr.read(c)) != -1){
//                System.out.println(char(c));
//            }
////            int ch = isr.read();
////            System.out.println((char) ch);
////            int ch2 = isr.read();
////            System.out.println((char) ch2);
////            int ch3 = isr.read();
////            System.out.println((char) ch3);
//
//        }
    }
}
