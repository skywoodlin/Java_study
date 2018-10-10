package medium.propertiesTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * Created by xjlin on 2018/10/9.
 */
public class PropertiesDemo{
    public static void main(String[] args) throws IOException{
        /**
         * 演示Properties的特有方法
         */
//        methodDemo();
//        methodDemo2();
        methodDemo3();
    }

    //基本存取
    public static void methodDemo(){

        //1. 存
        Properties prop = new Properties();
        prop.setProperty("zhangsan", "20");
        prop.setProperty("lisi", "21");
        prop.setProperty("wangwu", "22");

        //2. 取
        Set<String> set = prop.stringPropertyNames();

        for(String name : set){
            String value = prop.getProperty(name);
            System.out.println(name + ": " + value);
        }

        //显示到输出流
        prop.list(System.out); //少用， 一般用于调试
    }


    // 持久化到设备上（流）
    public static void methodDemo2() throws IOException{
        Properties prop = new Properties();
        prop.setProperty("zhangsan", "20");
        prop.setProperty("lisi", "21");
        prop.setProperty("wangwu", "22");

        FileOutputStream fos = new FileOutputStream("d:\\test\\info.properties");

        //使用prop的store方法,
        prop.store(fos, "my demo, person info");

        fos.close();
    }

    // 从设备上(流)读取
    public static void methodDemo3() throws IOException{
        File configFile = new File("d:\\test\\info.properties");

        Properties prop = new Properties();

        //定义读取流和数据文件关联
        FileInputStream fis = new FileInputStream(configFile);
        prop.load(fis);

        //修改值
        prop.setProperty("zhangsan", "12");

        //修改完的值写回输出流
        FileOutputStream fos = new FileOutputStream(configFile);
        prop.store(fos, "after modify");

        prop.list(System.out);
        fis.close();
        fos.close();

    }
}
