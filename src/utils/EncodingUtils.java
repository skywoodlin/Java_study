package utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xjlin on 2018/10/12.
 */
public class EncodingUtils{
    private static final String UTF8 = "UTF-8";

    /**
     * 打印不同字符集下Java字符串所占的字节数
     * @param str   待操作的字符串
     * @param encodingName 字符集名称
     */
    public static void printByteLength(String str, String encodingName){
        System.out.print("字节数 : ");
        try{
            byte[] bytes = str.getBytes(encodingName);
            System.out.print(bytes.length);
            System.out.print("； 编码： " + encodingName);
            System.out.println("； 二进制表示： " + ToBinaryStringUtils.byteArrToBinaryForShow(bytes));
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    /**
     * 返回默认的字符编码方式
     *
     * @return
     */
    public static String getDefaultCharset(){
        return Charset.defaultCharset().name();
    }

    /**
     * 返回所有可用的字符集， 字符串形式
     *
     * @return
     */
    public static String getAvailableCharset(){
        Map<String, Charset> charsetMap = Charset.availableCharsets();
        Set<String> keySet = charsetMap.keySet(); //因为set中是唯一的， hashMap的key也是唯一的
        int numOfCharset = keySet.size();

        String[] charsetNameArr = new String[numOfCharset];

        int index = 0;
        for(Iterator<String> it = keySet.iterator(); it.hasNext(); ){
            String key = it.next();
            Charset set = charsetMap.get(key);
            charsetNameArr[index++] = set.name();
        }

        return Arrays.toString(charsetNameArr);
    }

    public static List<Charset> getAvailableCharsetList(){
        List<Charset> charsetList = new ArrayList<>();

        Map<String, Charset> charsetMap = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> entrySet = charsetMap.entrySet();

        for(Iterator<Map.Entry<String, Charset>> it = entrySet.iterator(); it.hasNext(); ){
            Map.Entry<String, Charset> entry = it.next();
            charsetList.add(entry.getValue());
        }

        return charsetList;
    }

    /**
     * 打印所有的字符集
     */
    public static void printAvailableCharset(){
        Set<String> charsetNames = Charset.availableCharsets().keySet();
        System.out.println("-----the number of jdk1.8's charsets is: " + charsetNames.size() + "-----");
        for(Iterator it = charsetNames.iterator(); it.hasNext(); ){
            String charsetName = (String) it.next();
            System.out.println(charsetName);
        }
    }

    /**
     * 打印所有的字符集
     */
    public static void printAvailableCharset2(){
        Map<String, Charset> charsetMap = Charset.availableCharsets();

        Collection<Charset> charsets = charsetMap.values();

        int numOfCharset = charsets.size();

        System.out.println("-----the number of jdk1.8's charsets is: " + numOfCharset + "-----");

        for(Iterator it = charsets.iterator(); it.hasNext(); ){
            Charset charset = (Charset) it.next();
            System.out.println(charset.name());
        }
    }

    /**
     * @return
     */
    public static Collection<Charset> getAvailableCharsetSet(){
        Map<String, Charset> charsetMap = Charset.availableCharsets();
        Collection<Charset> charsets = charsetMap.values();
        return charsets;
    }
}
