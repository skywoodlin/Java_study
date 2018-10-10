package basic.io.charstream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by xjlin on 2018/10/8.
 */
public class SubTransStream{
    private static final String FILE_STR = "d:\\test\\ouputdata2.txt";

    public static void main(String[] args) throws IOException{
        writeText();
        readText();
    }

    private static void readText() throws IOException{
        FileReader fr = new FileReader(FILE_STR);

        int ch = -1;

        while((ch = fr.read()) != -1) {
            System.out.println((char)ch);
        }

        fr.close();
    }

    private static void writeText() throws IOException{
        FileWriter fw = new FileWriter(FILE_STR);
        //上面这句等效于：
        //FileOutputStream fos = new FileOutputStream(FILE_STR);
        //OutputStreamWriter osw = new OutputStreamWriter(fos);

        fw.write("你好");
        fw.close();
    }


}
