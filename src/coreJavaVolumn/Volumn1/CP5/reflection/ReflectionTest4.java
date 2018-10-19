package coreJavaVolumn.Volumn1.CP5.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by xjlin on 2018/8/28.
 *
 * 通过一个类的指定构造函数创建对象。
 */
public class ReflectionTest4{
    
    public static Class<?> getClassTest(Object obj) throws Exception {
//           return obj.getClass().getClassLoader().loadClass();
        //未完待续
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException{
        String name = "coreJavaVolumn.Volumn1.CP4.Employee";
        Class clazz = Class.forName(name);

        Constructor cons1 = clazz.getConstructor();
        //获得带参数的构造函数
        Constructor cons2 = clazz.getConstructor(String.class, double.class, int.class,int.class,int.class);

        System.out.println(cons1);
        System.out.println(cons2);

        Object object = cons2.newInstance("abc", 1.2, 1983, 7, 18);
        System.out.println();


    }
}
