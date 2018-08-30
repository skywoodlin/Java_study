package basic.java.util.scanner;

import java.util.Scanner;

/**
 * Created by xjlin on 2018/8/28.
 */
public class ScannerTest1{
    public static void main(String[] args){
        //从命令行中读取数字， 如果第一个非空字符不是数字会报错
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(i);

//        扫描器还可以使用不同于空白的分隔符。下面是从一个字符串读取若干项的例子：
        String input = "1 fish 2 fish red fish blue fish";
        Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
        System.out.println(s.nextInt());
        System.out.println(s.nextInt());
        System.out.println(s.next());
        System.out.println(s.next());
        s.close();

    }
}
