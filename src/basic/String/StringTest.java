package basic.String;

import java.util.Arrays;

/**
 * Created by xjlin on 2018/9/6.
 */

public class StringTest {
    /**
     * @param args
     */
    public static void main(String[] args) {

        /*
         * 需求5：对字符串中字符进行自然顺序排序。
         * 思路：
         * 1，要排序，我会！但是只会数组排序。
         * 2，怎么能把字符串转成数组呢？
         * 3，到字符串中的找方法。
         * 4，排序我熟。
         * 5，将排序后的数组变成字符串
         *
         */

        String str = "jbdsakncv";

        String sortString = sortChar(str);
        System.out.println(sortString);
    }
    /**
     * 对给定的字符串进行字符排序。并返回排序后字符串。
     * @param str
     * @return
     */
    public static String sortChar(String str) {

        //1,将字符串转成字符数组。
        char[] chs = stringToArray(str);

        //2,对数组排序。
        sort(chs);

        //3,将数组转成字符串。
        return toString(chs);
    }
    /*
     * 将字符数组转成字符串。
     */
    private static String toString(char[] chs) {

        return new String(chs);
    }
    /*
     * 对字符数组进行升序排序。
     */
    private static void sort(char[] chs) {

        Arrays.sort(chs);

    }
    /*
     * 将字符串转成字符数组。
     */
    private static char[] stringToArray(String str) {

        return str.toCharArray();
    }

}
