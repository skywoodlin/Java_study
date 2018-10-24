package utils.utilTest;

import utils.EncodingUtils;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import static utils.EncodingUtils.printByteLength;

/**
 * Created by xjlin on 2018/10/12.
 */
public class EncodingUtilsTest{
    public static void main(String[] args){

//        System.out.println(EncodingUtils.getDefaultCharset()); //UTF-8
//        System.out.println(EncodingUtils.getAvailableCharset());
//        EncodingUtils.printAvailableCharset();
        EncodingUtils.printAvailableCharset2();

//        Collection<Charset> availableCharsetSet = EncodingUtils.getAvailableCharsetSet();
//        for(Iterator it = availableCharsetSet.iterator(); it.hasNext(); ){
//            Charset charset = (Charset) it.next();
//            System.out.println(charset.name());
//        }

        String en = "A";

        String ch = "人";

        System.out.println("英文字母：" + en);

        printByteLength(en, "GB2312");

        printByteLength(en, "GBK");

        printByteLength(en, "GB18030");

        printByteLength(en, "ISO-8859-1");

        printByteLength(en, "UTF-8");

        printByteLength(en, "UTF-16");

        printByteLength(en, "UTF-16BE");

        printByteLength(en, "UTF-16LE");

        System.out.println();



        System.out.println("中文汉字：" + ch);

        printByteLength(ch, "GB2312");

        printByteLength(ch, "GBK");

        printByteLength(ch, "GB18030");

        printByteLength(ch, "ISO-8859-1");

        printByteLength(ch, "UTF-8");

        printByteLength(ch, "UTF-16");

        printByteLength(ch, "UTF-16BE");

        printByteLength(ch, "UTF-16LE");
    }
}
