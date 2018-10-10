package basic.io.charstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by xjlin on 2018/10/8.
 */
public class OutputStreamWriterDemo{
    private static final String FILE_STR = "d:\\test\\outputData.txt";

    public static void main(String[] args) throws IOException{
        FileOutputStream fos = new FileOutputStream(FILE_STR);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        osw.write("您好a你好");
        osw.flush();
        osw.close();
    }

}
