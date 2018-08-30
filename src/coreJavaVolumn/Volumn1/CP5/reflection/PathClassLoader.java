package coreJavaVolumn.Volumn1.CP5.reflection;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by xjlin on 2018/8/28.
 * http://www.cnblogs.com/xujian2014/p/5551153.html
 * //创建自己的类加载器， 加载自己硬盘上的class文件
 * 1、为何要自定义类加载器？
 *
 * 　　JVM提供的类加载器，只能加载指定目录的jar和class，如果我们想加载其他位置的类或jar时，例如加载网络上的一个class文件，默认的ClassLoader就不能满足我们的需求了，所以需要定义自己的类加载器。
 *
 * 　　2、如何实现自定义的类加载器？
 *
 * 　　我们实现一个ClassLoader，并指定这个ClassLoader的加载路径。有两种方式：
 *
 * 　　方式一：继承ClassLoader，重写父类的findClass()方法，代码如下
 */
public class PathClassLoader extends ClassLoader{
    public static final String drive = "D:\\test\\testClassLoader\\";
    public static final String fileType = ".class";

    public static void main(String[] args) throws Exception{
        PathClassLoader loader = new PathClassLoader();
        //加载指定类，注意一定要带上类的包名
        Class<?> objClass = loader.loadClass("coreJavaVolumn.Volumn1.CP5.reflection.ClassloaderTestObj", true);
        //初始化一个实例
        Object obj = objClass.newInstance();

        Method method = objClass.getDeclaredMethod("add", int.class, int.class);
        Object o = method.invoke(obj, 1, 2);
        System.out.println(o);
        System.out.println(objClass.getName());
        System.out.println(objClass.getClassLoader());
        System.out.println(obj.getClass().toString());
//        System.out.println();
    }

    public Class<?> findClass(String name){
        byte[] data = loadClassData(name);
        return defineClass(name, data, 0, data.length);// 将一个 byte 数组转换为 Class// 类的实例
    }

    public byte[] loadClassData(String name){
        FileInputStream fis = null;
        byte[] data = null;
        try{
            fis = new FileInputStream(new File(drive + name + fileType));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int ch = 0;
            while((ch = fis.read()) != -1){
                baos.write(ch);
            }
            data = baos.toByteArray();
        }catch(IOException e){
            e.printStackTrace();
        }
        return data;
    }
}
