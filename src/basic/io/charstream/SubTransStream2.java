package basic.io.charstream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by xjlin on 2018/10/8.
 */
public class SubTransStream2{
    private static final String FILE_STR = "d:\\test\\ouputdata2.txt";
    private static final String FILE_STR_DEST = "d:\\test\\ouputdata2_copy.txt";

    public static void main(String[] args) throws IOException{
        copyText();
//        readText();
    }

    private static void readText() throws IOException{

    }

    private static void copyText() throws IOException{
        FileReader fr = new FileReader(FILE_STR);
        FileWriter fw = new FileWriter(FILE_STR_DEST);

        //创建缓冲区
        char[] buf = new char[1024];
        int len = -1;
        while((len=fr.read(buf)) != -1) {
            fw.write(buf,0,len);
        }

        fw.close();
        fr.close();

    }


}
