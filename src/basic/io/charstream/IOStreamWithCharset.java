package basic.io.charstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xjlin on 2018/10/8.
 */
public class IOStreamWithCharset{
    private static final String FILE_STR = "d:\\test\\data.txt";

    public static void main(String[] args) throws IOException{
        readGBK();
        readUtf_8();
    }

    public static void readGBK() throws IOException{
        InputStreamReader isr = new InputStreamReader(new FileInputStream(FILE_STR),"GBK");
        int ch = -1;
        while((ch = isr.read()) != -1) {
            System.out.println((char)ch);
        }
    }

    public static void readUtf_8() throws IOException{
        InputStreamReader isr = new InputStreamReader(new FileInputStream(FILE_STR),"UTF-8");
        int ch = -1;
        while((ch = isr.read()) != -1) {
            System.out.println((char)ch);
        }
    }
}
