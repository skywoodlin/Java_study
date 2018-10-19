package utils.utilTest;

import utils.ToBinaryStringUtils;

import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * Created by xjlin on 2018/10/11.
 */
public class ToBinaryStringUtilsTest{
    public static void main(String[] args) throws UnsupportedEncodingException{
        System.out.println(ToBinaryStringUtils.intToBinaryForShow(-1)); //11111111 11111111 11111111 11111111
        System.out.println(ToBinaryStringUtils.longToBinaryForShow(333L)); //101001101
        System.out.println(ToBinaryStringUtils.doubleToBinaryForShow(44.4)); //11111111 11111111 11111111 11111111

//        System.out.println(Character.toString('牛'));

        char c1 = '中';
        char c2 = '国';
        char c3 = '国' + '国';

        System.out.println(ToBinaryStringUtils.charToBinaryForShow(c1));//1001110 00101101
        System.out.println(ToBinaryStringUtils.charToBinaryForShow(c2));//1010110 11111101
        System.out.println(ToBinaryStringUtils.charToBinaryForShow(c3));//10101101 11111010

        System.out.println(ToBinaryStringUtils.charToBinary(c1));
        System.out.println(ToBinaryStringUtils.charToBinary(c2));
        System.out.println(ToBinaryStringUtils.charToBinary(c3));

        System.out.println("当前系统编码： " + System.getProperty("file.encoding"));

        byte[] bt1 = "中".getBytes("gbk");
        System.out.println("’中’字的二进制为(gbk)： ");
        for(byte bt: bt1) {
            System.out.println(ToBinaryStringUtils.byteToBinary(bt));
        }

        byte[] bt2 = "中".getBytes("utf-8");
        System.out.println("’中’字的二进制为(utf-8)： ");
        for(byte bt: bt2) {
            System.out.println(ToBinaryStringUtils.byteToBinary(bt));
        }

        Character c4 = '中';

        CharBuffer charBuffer = CharBuffer.allocate(1);
        charBuffer.append(c4);

        //
        System.out.println("某string.getBytes()使用的编码为： ");
        String csn = Charset.defaultCharset().name();
        System.out.println(csn);


        char[] chars = Character.toChars('中');
        for(char c:chars) {
            System.out.println(c);
        }
    }
}
