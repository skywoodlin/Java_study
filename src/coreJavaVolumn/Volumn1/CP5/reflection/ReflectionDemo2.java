package coreJavaVolumn.Volumn1.CP5.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by xjlin on 2018/12/10.
 */
public class ReflectionDemo2{
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException{
        /**
         * 演示如何通过反射取得对象
         */
        getObject2();
//        getObject();
    }

    public static void getObject() throws ClassNotFoundException, IllegalAccessException, InstantiationException{
        String className = "coreJavaVolumn.Volumn1.CP5.reflection.domain.Person";
        Class clazz = Class.forName(className);
        /**
         * 记住了， 一般被反射的类通常都有空参数的构造函数
         */
        Object object = clazz.newInstance(); //调用默认空参数构造函数创建一个Person对象
    }

    /**
     * 如果类没有空参数的构造函数
     * 可以通过获取指定的构造函数来生成实例
     *
     * 获取带俩参数的构造函数
     */
    public static void getObject2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException{
        String className = "coreJavaVolumn.Volumn1.CP5.reflection.domain.Person";
        Class clazz = Class.forName(className);
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("abc", 1);
    }

}
