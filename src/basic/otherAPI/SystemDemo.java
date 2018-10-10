package basic.otherAPI;

import java.util.Date;
import java.util.Properties;

/**
 * Created by xjlin on 2018/9/10.
 */
public class SystemDemo{
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args){

        long time = System.currentTimeMillis();
        System.out.println(time);

        Date date = new Date(1374043007468l);
        System.out.println(date);  //Wed Jul 17 14:36:47 CST 2013: 2013.7.17

        //System中的getProperties()方法
        Properties properties = System.getProperties(); //Properties是Hashtable
        System.out.println("System.getProperties的所有属性如下： ");
        for(String key: properties.stringPropertyNames()) {
            System.out.println(key + ": " + properties.getProperty(key));
        }

        //测试路径
        System.out.println("c:" + FILE_SEPARATOR+"abc"+FILE_SEPARATOR+"def.txt"); //windows下c:\abc\def.txt
        
        //换行符
        System.out.println("hello" + LINE_SEPARATOR + "world");

    }
}
