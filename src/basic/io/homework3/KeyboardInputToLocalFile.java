package basic.io.homework3;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by xjlin on 2018/10/9.
 */
public class KeyboardInputToLocalFile{
    public static void main(String[] args) throws IOException{
//        method1(); //第一种方法, 要回车
        method2();// 同样要回车

    }

    private static void method1() throws IOException{
        String last4Bytes = "";

        InputStream a;
        a = System.in;
        while(true) {
            char inputChar = (char) a.read();
            if(inputChar == '\n') {
                continue;
            }
            last4Bytes = last4BytesToString(last4Bytes, inputChar);
            System.out.println(String.valueOf(inputChar).toUpperCase());
            System.out.println(last4Bytes);
            if("over".equals(last4Bytes)) {
                System.exit(0);
            }
        }
    }

    private static void method2() throws IOException{
        Scanner scan = new Scanner(System.in) ; // 从键盘接收数据
        String str = scan.next(); // 接收数据
        do{
            System.out.println("输入的字符为： " + str) ;
        } while(!"over".equals(str = scan.next()));//不能直接把字符串转换为布尔值
    }




    private static String last4BytesToString(String last4Bytes, char b) {
        if(last4Bytes.length() < 4) {
            return last4Bytes + b;
        }

        StringBuilder sb = new StringBuilder(last4Bytes.substring(1,4));
        return sb.append(b).toString();
    }
}


