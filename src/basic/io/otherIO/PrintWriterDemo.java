package basic.io.otherIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by xjlin on 2018/10/18.
 */
public class PrintWriterDemo{
    public static void main(String[] args) throws IOException{
        //读取键盘录入, 转成大写显示

        //1. 键盘录入
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        //等同于
        //BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.in));

        //2. 定义目的, 对println会刷新缓冲区
        PrintWriter pw = new PrintWriter(System.out, true);

        //改变目的为文件， 还想自动刷新, 还想高效
//        pw = new PrintWriter(new BufferedWriter(new FileWriter("filename")), true);

        //3. 读一行写一行
        String line = null;
        while((line=bufr.readLine()) != null) {
            if("over".equals(line)) {
                break;
            }
            pw.println(line.toUpperCase());
//            pw.flush();
        }

        //1. 关闭资源之前会自动刷新缓冲区数据，
        // 2. pw初始化使用autoFlush=true时， println才会自动刷新缓冲区
        pw.close();
        //bufr.close(); //不需要关闭键盘输入这种标准输入流， 一旦关闭后面其它程序就获取不到了

    }
}
